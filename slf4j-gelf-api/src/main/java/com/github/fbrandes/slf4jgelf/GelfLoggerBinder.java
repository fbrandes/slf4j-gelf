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

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class GelfLoggerBinder implements LoggerFactoryBinder {
    private static final GelfLoggerBinder INSTANCE = new GelfLoggerBinder();
    private static final String LOGGER_FACTORY_CLASS_NAME = GelfLoggerFactory.class.getName();

    private final ILoggerFactory loggerFactory;

    private GelfLoggerBinder() {
        loggerFactory = new GelfLoggerFactory();
    }

    public static GelfLoggerBinder getInstance() {
        return INSTANCE;
    }

    public ILoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    public String getLoggerFactoryClassStr() {
        return LOGGER_FACTORY_CLASS_NAME;
    }
}
