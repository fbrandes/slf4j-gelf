package com.github.fbrandes.slf4jgelf.impl;

import com.github.fbrandes.slf4jgelf.GelfLoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Tests for facade usage with log4j")
class Log4j2Test {
    private static final Logger LOGGER = new GelfLoggerFactory().getLogger(Log4j2Test.class);

    private String logFileName = "slf4jgelf.log";

    @Test
    void test() throws IOException {
        LOGGER.info("test");

        String loggedMessage = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertNotNull(loggedMessage);
        assertTrue(loggedMessage.contains("\"host\":"));
        assertTrue(loggedMessage.contains("\"short_message\":"));
        assertTrue(loggedMessage.contains("\"full_message\":"));
        assertTrue(loggedMessage.contains("\"timestamp\":"));
        assertTrue(loggedMessage.contains("\"level\":"));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.delete(Paths.get(logFileName));
    }
}
