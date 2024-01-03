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
package com.github.fbrandes.slf4jgelf.simple;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleGelfLoggerFactory implements ILoggerFactory {
    private final Map<String, SimpleGelfLogger> loggerMap;
    @Getter @Setter private boolean includeLoggerName = true;
    @Getter @Setter private boolean includeClassName = true;
    @Getter @Setter private boolean includeThreadName = true;
    @Getter @Setter private boolean includeMdc = true;

    public SimpleGelfLoggerFactory() {
        loggerMap = new ConcurrentHashMap<>();
    }

    public Logger getLogger(Class<?> clazz) {
        return getLogger(clazz.getName());
    }

    public Logger getLogger(String name) {
        synchronized (loggerMap) {
            loggerMap.computeIfAbsent(name, s -> {
                SimpleGelfLogger logger = new SimpleGelfLogger();
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
