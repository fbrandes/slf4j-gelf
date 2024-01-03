package com.github.fbrandes.slf4jgelf;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

public class GelfLoggerAdapter implements GelfLogger {
    private static final String FQDN = GelfLoggerAdapter.class.getName();

    private final Logger logger;
    private final boolean isTraceCapable;
    private final GelfFormatter gelfFormatter;

    @Getter @Setter private boolean includeLoggerName;
    @Getter @Setter private boolean includeClassName;
    @Getter @Setter private boolean includeThreadName;
    @Getter @Setter private boolean includeMdc;

    public GelfLoggerAdapter(Logger logger) {
        this.logger = logger;
        gelfFormatter = new GelfFormatter();
        isTraceCapable = true;
    }

    @Override
    public String getName() {
        return FQDN;
    }

    public boolean isTraceEnabled() {
        return isTraceCapable ? logger.isTraceEnabled() : logger.isDebugEnabled();
    }

    public void trace(final String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.TRACE);
        logger.trace(message);
    }

    public void trace(final String format, final Object arg) {
        String message = getFormattedMessage(format, arg);
        logger.trace(message, arg);
    }

    public void trace(String format, Object arg1, Object arg2) {
        logger.trace(format, arg1, arg2);
    }

    public void trace(String format, Object... arguments) {
        logger.trace(format, arguments);
    }

    public void trace(final String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.TRACE);
        logger.trace(message, throwable);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return logger.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.TRACE, marker);
        logger.trace(marker, message);
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg), Level.TRACE, marker);
        logger.trace(marker, message, arg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg1, arg2), Level.TRACE, marker);
        logger.trace(marker, message, arg1, arg2);
    }

    @Override
    public void trace(Marker marker, String format, Object... arguments) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arguments), Level.TRACE, marker);
        logger.trace(marker, message, arguments);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.TRACE, marker);
        logger.trace(marker, message, throwable);
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public void debug(String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.DEBUG);
        logger.debug(message);
    }

    public void debug(String format, Object arg) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg), Level.DEBUG);
        logger.debug(message, arg);
    }

    public void debug(String format, Object arg1, Object arg2) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg1, arg2), Level.DEBUG);
        logger.debug(message, arg1, arg2);
    }

    public void debug(String format, Object... arguments) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arguments), Level.DEBUG);
        logger.debug(message, arguments);
    }

    public void debug(String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.DEBUG);
        logger.debug(message, throwable);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return logger.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.DEBUG, marker);
        logger.debug(marker, message);
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg), Level.DEBUG, marker);
        logger.debug(marker, message, arg);
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg1, arg2), Level.DEBUG, marker);
        logger.debug(marker, message, arg1, arg2);
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arguments), Level.DEBUG, marker);
        logger.debug(marker, message, arguments);
    }

    @Override
    public void debug(Marker marker, String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.DEBUG, marker);
        logger.debug(marker, message, throwable);
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public void info(String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.INFO);
        logger.info(message);
    }

    public void info(String format, Object arg) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg), Level.INFO);
        logger.info(message, arg);
    }

    public void info(String format, Object arg1, Object arg2) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg1, arg2), Level.INFO);
        logger.info(message, arg1, arg2);
    }

    public void info(String format, Object... arguments) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arguments), Level.INFO);
        logger.info(message, arguments);
    }

    public void info(String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.INFO);
        logger.info(message, throwable);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return logger.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.INFO, marker);
        logger.info(marker, message);
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg), Level.INFO, marker);
        logger.info(marker, message, arg);
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg1, arg2), Level.INFO, marker);
        logger.info(marker, message, arg1, arg2);
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arguments), Level.INFO, marker);
        logger.info(marker, message, arguments);
    }

    @Override
    public void info(Marker marker, String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.INFO, marker);
        logger.info(marker, message, throwable);
    }

    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    public void warn(String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.WARN);
        logger.warn(message);
    }

    public void warn(String format, Object arg) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg), Level.WARN);
        logger.warn(message, arg);
    }

    public void warn(String format, Object... arguments) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arguments), Level.WARN);
        logger.warn(message, arguments);
    }

    public void warn(String format, Object arg1, Object arg2) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg1, arg2), Level.WARN);
        logger.warn(message, arg1, arg2);
    }

    public void warn(String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.WARN);
        logger.warn(message, throwable);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return logger.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.WARN, marker);
        logger.warn(marker, message);
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg), Level.WARN, marker);
        logger.warn(marker, message, arg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg1, arg2), Level.WARN, marker);
        logger.warn(marker, message, arg1, arg2);
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arguments), Level.WARN, marker);
        logger.warn(marker, message, arguments);
    }

    @Override
    public void warn(Marker marker, String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.WARN, marker);
        logger.warn(marker, message, throwable);
    }

    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    public void error(String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.ERROR);
        logger.error(message);
    }

    public void error(String format, Object arg) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg), Level.ERROR);
        logger.error(message, arg);
    }

    public void error(String format, Object arg1, Object arg2) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg1, arg2), Level.ERROR);
        logger.error(message, arg1, arg2);
    }

    public void error(String format, Object... arguments) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arguments), Level.ERROR);
        logger.error(message, arguments);
    }

    public void error(String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.ERROR);
        logger.error(message, throwable);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return logger.isInfoEnabled(marker);
    }

    @Override
    public void error(Marker marker, String msg) {
        String message = gelfFormatter.toGelf(this, msg, Level.ERROR, marker);
        logger.error(marker, message);
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg), Level.ERROR, marker);
        logger.error(marker, message, arg);
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arg1, arg2), Level.ERROR, marker);
        logger.error(marker, message, arg1, arg2);
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        String message = gelfFormatter.toGelf(this, getFormattedMessage(format, arguments), Level.ERROR, marker);
        logger.error(marker, message, arguments);
    }

    @Override
    public void error(Marker marker, String msg, Throwable throwable) {
        String message = gelfFormatter.toGelf(this, msg, Level.ERROR, marker);
        logger.error(marker, message, throwable);
    }

    private String getFormattedMessage(String format, Object... args) {
        return MessageFormatter.format(format, args).getMessage();
    }
}
