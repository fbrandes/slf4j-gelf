package com.github.fbrandes.slf4jgelf;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.MDC;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MdcTest {
    private Logger LOGGER = new GelfLoggerFactory().getLogger(MdcTest.class);
    private String logFileName = "slf4jgelf.log";

    @Test
    void testMdcInGelfMessage() throws IOException {
        MDC.put("some", "key");

        LOGGER.info("foo");
        String loggedMessage = new String(Files.readAllBytes(Paths.get(logFileName)));

        assertTrue(loggedMessage.contains("\"_some\":\"key\""));
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.delete(Path.of(logFileName));
    }
}
