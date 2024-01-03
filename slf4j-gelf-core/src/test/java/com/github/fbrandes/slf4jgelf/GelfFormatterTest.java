package com.github.fbrandes.slf4jgelf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GelfFormatterTest {
    private GelfLogger loggerAdapter;
    @BeforeEach
    void setup() {
        loggerAdapter = new GelfLogger();
    }

    @Test
    void testWithoutAdditionalFields() {
        String message = new GelfFormatter().toGelf(loggerAdapter, "foo", Level.INFO);

        assertTrue(message.contains("\"short_message\":\"foo\""));
        assertTrue(message.contains("\"host\":"));
        assertTrue(message.contains("\"full_message\":\"foo\""));
        assertTrue(message.contains("\"timestamp\":"));
        assertTrue(message.contains("\"level\":"));
    }

    @Test
    void testToJson() {
        MDC.put("foo", "foo");
        MDC.put("bar", "bar");

        String message = new GelfFormatter().toGelf(loggerAdapter, "foo", Level.INFO);

        assertTrue(message.contains("\"short_message\":\"foo\""));
        assertTrue(message.contains("\"host\":"));
        assertTrue(message.contains("\"full_message\":\"foo\""));
        assertTrue(message.contains("\"timestamp\":"));
        assertTrue(message.contains("\"level\":"));
    }

    @Test
    void testWithMarker() {
        Marker marker = MarkerFactory.getMarker("TEST");
        String message = new GelfFormatter().toGelf(loggerAdapter, "foo", Level.INFO, marker);

        assertTrue(message.contains("\"_marker\":\"TEST\""));
    }
}
