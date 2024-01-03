package com.github.fbrandes.slf4jgelf.impl;

import com.github.fbrandes.slf4jgelf.GelfLoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConsoleAppenderTest {
    private static final Logger LOGGER = new GelfLoggerFactory().getLogger(FileAppenderTest.class);

    private final ConsoleOutputCapturer outputCapturer = new ConsoleOutputCapturer();

    @BeforeEach
    void setup() {
        outputCapturer.start();
    }

    @Test
    void shouldLogToConsole() {
        LOGGER.info("test");

        String loggedMessage = outputCapturer.getOutput();
        assertNotNull(loggedMessage);
        assertTrue(loggedMessage.contains("\"host\":"));
        assertTrue(loggedMessage.contains("\"short_message\":"));
        assertTrue(loggedMessage.contains("\"full_message\":"));
        assertTrue(loggedMessage.contains("\"timestamp\":"));
        assertTrue(loggedMessage.contains("\"level\":"));
    }

    @AfterEach
    void tearDown() {
        outputCapturer.stop();
    }
}
