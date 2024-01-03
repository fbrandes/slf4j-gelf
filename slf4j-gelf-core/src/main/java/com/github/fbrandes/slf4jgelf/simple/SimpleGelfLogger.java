package com.github.fbrandes.slf4jgelf.simple;

import com.github.fbrandes.slf4jgelf.GelfFormatter;
import com.github.fbrandes.slf4jgelf.GelfLogger;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.helpers.MessageFormatter;

public class SimpleGelfLogger implements GelfLogger {
    private static final String FQDN = SimpleGelfLogger.class.getName();
    private final GelfFormatter gelfFormatter;

    @Getter @Setter private boolean includeLoggerName;
    @Getter @Setter private boolean includeClassName;
    @Getter @Setter private boolean includeThreadName;
    @Getter @Setter private boolean includeMdc;

    private Level currentLogLevel;

    public SimpleGelfLogger() {
        gelfFormatter = new GelfFormatter();
    }

    @Override
    public String getName() {
        return FQDN;
    }

    @Override
    public boolean isTraceEnabled() {
        return isLevelEnabled(Level.TRACE);
    }

    @Override
    public void trace(String msg) {
        log(Level.TRACE, null, msg, null);
    }

    @Override
    public void trace(String format, Object arg) {
        log(Level.TRACE, null, getFormattedMessage(format, arg), null);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        log(Level.TRACE, null, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void trace(String format, Object... arguments) {
        log(Level.TRACE, null, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void trace(String msg, Throwable t) {
        log(Level.TRACE, null, msg, t);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return isTraceEnabled();
    }

    @Override
    public void trace(Marker marker, String msg) {
        log(Level.TRACE, marker, msg, null);
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        log(Level.TRACE, marker, getFormattedMessage(format, arg), null);
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.TRACE, marker, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void trace(Marker marker, String format, Object... arguments) {
        log(Level.TRACE, marker, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        log(Level.TRACE, marker, msg, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return isLevelEnabled(Level.DEBUG);
    }

    @Override
    public void debug(String msg) {
        log(Level.DEBUG, null, msg, null);
    }

    @Override
    public void debug(String format, Object arg) {
        log(Level.DEBUG, null, getFormattedMessage(format, arg), null);
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        log(Level.DEBUG, null, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void debug(String format, Object... arguments) {
        log(Level.DEBUG, null, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void debug(String msg, Throwable t) {
        log(Level.DEBUG, null, msg, t);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return isDebugEnabled();
    }

    @Override
    public void debug(Marker marker, String msg) {
        log(Level.DEBUG, marker, msg, null);
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        log(Level.DEBUG, marker, getFormattedMessage(format, arg), null);
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.DEBUG, marker, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        log(Level.DEBUG, marker, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        log(Level.DEBUG, marker, msg, t);
    }

    @Override
    public boolean isInfoEnabled() {
        return isLevelEnabled(Level.INFO);
    }

    @Override
    public void info(String msg) {
        log(Level.INFO, null, msg, null);
    }

    @Override
    public void info(String format, Object arg) {
        log(Level.INFO, null, getFormattedMessage(format, arg), null);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        log(Level.INFO, null, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void info(String format, Object... arguments) {
        log(Level.INFO, null, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void info(String msg, Throwable t) {
        log(Level.INFO, null, msg, t);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return isInfoEnabled();
    }

    @Override
    public void info(Marker marker, String msg) {
        log(Level.INFO, marker, msg, null);
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        log(Level.INFO, marker, getFormattedMessage(format, arg), null);
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.INFO, marker, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        log(Level.INFO, marker, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        log(Level.INFO, marker, msg, t);
    }

    @Override
    public boolean isWarnEnabled() {
        return isLevelEnabled(Level.WARN);
    }

    @Override
    public void warn(String msg) {
        log(Level.WARN, null, msg, null);
    }

    @Override
    public void warn(String format, Object arg) {
        log(Level.WARN, null, getFormattedMessage(format, arg), null);
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        log(Level.WARN, null, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void warn(String format, Object... arguments) {
        log(Level.WARN, null, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void warn(String msg, Throwable t) {
        log(Level.WARN, null, msg, t);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return isWarnEnabled();
    }

    @Override
    public void warn(Marker marker, String msg) {
        log(Level.WARN, marker, msg, null);
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        log(Level.WARN, marker, getFormattedMessage(format, arg), null);
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.WARN, marker, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        log(Level.WARN, marker, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        log(Level.WARN, marker, msg, t);
    }

    @Override
    public boolean isErrorEnabled() {
        return isLevelEnabled(Level.ERROR);
    }

    @Override
    public void error(String msg) {
        log(Level.ERROR, null, msg, null);
    }

    @Override
    public void error(String format, Object arg) {
        log(Level.ERROR, null, getFormattedMessage(format, arg), null);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        log(Level.ERROR, null, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void error(String format, Object... arguments) {
        log(Level.ERROR, null, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void error(String msg, Throwable t) {
        log(Level.ERROR, null, msg, t);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return isErrorEnabled();
    }

    @Override
    public void error(Marker marker, String msg) {
        log(Level.ERROR, marker, msg, null);
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        log(Level.ERROR, marker, getFormattedMessage(format, arg), null);
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        log(Level.ERROR, marker, getFormattedMessage(format, arg1, arg2), null);
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        log(Level.ERROR, marker, getFormattedMessage(format, arguments), null);
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        log(Level.ERROR, marker, msg, t);
    }

    private String getFormattedMessage(String format, Object... args) {
        return MessageFormatter.format(format, args).getMessage();
    }

    private void log(Level level, Marker marker, String message, Throwable throwable) {
        String formattedMessage = gelfFormatter.toGelf(this, message,
                com.github.fbrandes.slf4jgelf.Level.valueOf(level.name()), marker);

        if (level.equals(Level.ERROR)) {
            System.err.println(formattedMessage);
        } else {
            System.out.println(formattedMessage);
        }
    }

    private boolean isLevelEnabled(Level logLevel) {
        return logLevel.toInt() >= currentLogLevel.toInt();
    }

    public void setLogLevel(Level level) {
        this.currentLogLevel = level;
    }
}
