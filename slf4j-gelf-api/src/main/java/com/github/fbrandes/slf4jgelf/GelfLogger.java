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
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.event.LoggingEvent;
import org.slf4j.helpers.AbstractLogger;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.simple.SimpleLogger;
import org.slf4j.simple.SimpleLoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
import org.slf4j.spi.LoggingEventAware;

import java.io.Serial;
import java.io.Serializable;

public class GelfLoggerAdapter extends AbstractLogger {
    @Serial
    private static final long serialVersionUID = -627010716671688365L;
    private static final String FQDN = GelfLoggerAdapter.class.getName();
    private final transient Logger logger;
    private final boolean isTraceCapable;
    private final transient GelfFormatter gelfFormatter;

    @Getter @Setter private boolean includeLoggerName;
    @Getter @Setter private boolean includeClassName;
    @Getter @Setter private boolean includeThreadName;
    @Getter @Setter private boolean includeMdc;

    public GelfLoggerAdapter(String name) {
        this.logger = new SimpleLoggerFactory().getLogger(name);
        this.name = name;
        gelfFormatter = GelfFormatter.getInstance();
        isTraceCapable = true;

    }

    @Override
    public String getName() {
        return FQDN;
    }

    @Override
    public boolean isTraceEnabled() {
        return false;
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override
    public boolean isDebugEnabled() {
        return false;
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override
    public boolean isInfoEnabled() {
        return false;
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override
    public boolean isWarnEnabled() {
        return false;
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override
    public boolean isErrorEnabled() {
        return false;
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override
    protected String getFullyQualifiedCallerName() {
        return null;
    }

    @Override
    protected void handleNormalizedLoggingCall(Level level, Marker marker, String messagePattern, Object[] arguments, Throwable throwable) {

    }

    @Override
    public void log(LoggingEvent event) {

    }
}
