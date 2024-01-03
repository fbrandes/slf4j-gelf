package com.github.fbrandes.slf4jgelf;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GelfLoggerFactory implements ILoggerFactory {
    private final Map<String, GelfLoggerAdapter> loggerMap;
    @Getter @Setter private static boolean includeLoggerName;
    @Getter @Setter private static boolean includeClassName;
    @Getter @Setter private static boolean includeThreadName;
    @Getter @Setter private static boolean includeMdc;

    public GelfLoggerFactory() {
        loggerMap = new ConcurrentHashMap<>();
    }

    public Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    public Logger getLogger(String name) {
        synchronized (loggerMap) {
            loggerMap.computeIfAbsent(name, s -> {
                GelfLoggerAdapter logger = new GelfLoggerAdapter(LoggerFactory.getLogger(name));
                logger.setIncludeClassName(includeClassName);
                logger.setIncludeLoggerName(includeLoggerName);
                logger.setIncludeThreadName(includeThreadName);
                logger.setIncludeMdc(includeMdc);
                return logger;
            });
        }
        return loggerMap.get(name);
    }
}
