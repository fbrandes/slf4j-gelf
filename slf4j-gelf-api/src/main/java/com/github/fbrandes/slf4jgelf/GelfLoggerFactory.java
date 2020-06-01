/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.fbrandes.slf4jgelf;

import lombok.Getter;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class GelfLoggerFactory implements ILoggerFactory {
    private final Map<String, GelfLoggerAdapter> loggerMap;
    @Getter private static boolean includeLoggerName = true;
    @Getter private static boolean includeClassName = true;
    @Getter private static boolean includeThreadName = true;
    @Getter private static boolean includeMdc = true;

    public GelfLoggerFactory() {
        loggerMap = new HashMap<>();
    }

    public Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    public Logger getLogger(String name) {
        synchronized (loggerMap) {
            if(!loggerMap.containsKey(name)) {
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
