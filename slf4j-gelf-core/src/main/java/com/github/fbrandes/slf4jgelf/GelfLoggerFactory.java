package com.github.fbrandes.slf4jgelf;

import com.github.fbrandes.slf4jgelf.GelfLoggerAdapter;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GelfLoggerFactory {
    private final Map<String, GelfLoggerAdapter> loggerMap;
    @Getter private static boolean includeLoggerName = true;
    @Getter private static boolean includeClassName = true;
    @Getter private static boolean includeThreadName = true;
    @Getter private static boolean includeMdc = true;

    public GelfLoggerFactory() {
        loggerMap = new ConcurrentHashMap<>();
    }

    public Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    public Logger getLogger(String name) {
        synchronized (loggerMap) {
            if (!loggerMap.containsKey(name)) {
                GelfLoggerAdapter logger = new GelfLoggerAdapter(LoggerFactory.getLogger(name));
                logger.setIncludeClassName(includeClassName);
                logger.setIncludeLoggerName(includeLoggerName);
                logger.setIncludeThreadName(includeThreadName);
                logger.setIncludeMdc(includeMdc);
                loggerMap.put(name, logger);
            }
        }
        return loggerMap.get(name);
    }
}
