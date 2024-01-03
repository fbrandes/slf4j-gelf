package com.github.fbrandes.slf4jgelf;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.slf4j.Marker;

import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Optional;

public class GelfFormatter {
    private Gson gson;

    private static final String HOSTNAME_LOCALHOST = "localhost";

    public GelfFormatter() {
        init();
    }

    private void init() {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithModifiers(Modifier.TRANSIENT);
        builder.enableComplexMapKeySerialization();
        gson = builder.create();
    }

    public String toGelf(Logger logger, String logMessage, Level level, Marker marker) {
        GelfMessage gelfMessage = newMessage(logger, logMessage,level);
        if (marker != null) {
            gelfMessage.getAdditionalFields().add("marker", marker.getName());
        }
        return gson.toJson(gelfMessage.getFields());
    }

    public String toGelf(Logger logger, String logMessage, Level level) {
        GelfMessage gelfMessage = newMessage(logger, logMessage, level);
        return gson.toJson(gelfMessage.getFields());
    }

    private GelfMessage newMessage(Logger logger, String logMessage, Level level) {
        String host = getHost();
        long timestamp = System.currentTimeMillis();
        AdditionalFields additionalFields = getAdditionalFields(logger);


        return GelfMessage.builder().host(host).level(level).fullMessage(logMessage).shortMessage(logMessage)
                .timestamp(timestamp).additionalFields(additionalFields).build();
    }

    private AdditionalFields getAdditionalFields(Logger logger) {
        AdditionalFields additionalFields = new AdditionalFields();

        if(logger instanceof GelfLogger gelfLogger) {
            if(gelfLogger.isIncludeMdc()) {
                Map<String, String> mdc = MDC.getCopyOfContextMap();
                if(mdc != null) {
                    additionalFields.addAll(mdc);
                }
            }

            if(gelfLogger.isIncludeLoggerName()) {
                additionalFields.add("logger_name", logger.getName());
            }

            if(gelfLogger.isIncludeClassName()) {
                StackTraceElement[] stackTraceElements = (new Exception()).getStackTrace();
                additionalFields.add("class", stackTraceElements[3].getClassName());
            }

            if(gelfLogger.isIncludeThreadName()) {
                additionalFields.add("thread_name", Thread.currentThread().getName());
            }
        }

        return additionalFields;
    }

    private String getHost() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            Optional<NetworkInterface> networkInterface;
            try {
                networkInterface = NetworkInterface.networkInterfaces().findFirst();
            } catch (SocketException e1) {
                return HOSTNAME_LOCALHOST;
            }

            if (networkInterface.isEmpty()) {
                return HOSTNAME_LOCALHOST;
            }

            Optional<InetAddress> inetAddress = networkInterface.get().inetAddresses().findFirst();
            if (inetAddress.isEmpty()) {
                return HOSTNAME_LOCALHOST;
            }

            return inetAddress.get().getHostName();
        }
    }
}
