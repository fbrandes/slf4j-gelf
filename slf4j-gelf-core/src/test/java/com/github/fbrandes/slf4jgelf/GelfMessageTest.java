package com.github.fbrandes.slf4jgelf;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GelfMessageTest {
    @Test
    void shouldCreateMessageFromBuilder() {
        GelfMessage message = GelfMessage
                .builder()
                .fullMessage("foo")
                .shortMessage("foo")
                .host("localhost")
                .level(Level.DEBUG)
                .timestamp(1234567890123L)
                .additionalFields(new AdditionalFields())
                .build();

        assertEquals("foo", message.getFullMessage());
        assertEquals("foo", message.getShortMessage());
        assertEquals("localhost", message.getHost());
        assertEquals(Level.DEBUG, message.getLevel());
        assertEquals(1234567890123L, message.getTimestamp());
        assertEquals(Map.of(), message.getAdditionalFields().getFields());
    }

    @Test
    void shouldCreateMessageFromSetters() {
        GelfMessage message = new GelfMessage("", "", "", 0L, Level.OFF, null);
        message.setFullMessage("bar");
        message.setShortMessage("bar");
        message.setHost("127.0.0.1");
        message.setLevel(Level.INFO);
        message.setTimestamp(1L);
        message.setAdditionalFields(new AdditionalFields());

        assertEquals("bar", message.getFullMessage());
        assertEquals("bar", message.getShortMessage());
        assertEquals("127.0.0.1", message.getHost());
        assertEquals(Level.INFO, message.getLevel());
        assertEquals(1L, message.getTimestamp());
        assertEquals(Map.of(), message.getAdditionalFields().getFields());
    }
}
