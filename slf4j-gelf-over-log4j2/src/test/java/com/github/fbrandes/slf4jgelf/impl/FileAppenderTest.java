package com.github.fbrandes.slf4jgelf.impl;

import com.github.fbrandes.slf4jgelf.GelfLoggerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.testcontainers.containers.FixedHostPortGenericContainer;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

//@Testcontainers
@DisplayName("Tests for facade usage with log4j")
class Log4j2Test {
    private static final Logger LOGGER = new GelfLoggerFactory().getLogger(Log4j2Test.class);

    private final String logFileName = "slf4jgelf.log";

//    @Container
//    public ElasticsearchContainer elasticsearchContainer = new ElasticsearchContainer(DockerImageName.parse("docker.elastic.co/elasticsearch/elasticsearch:8.11.1"));
//
//    @Container
//    public FixedHostPortGenericContainer<?> logstashContainer = new FixedHostPortGenericContainer<>(
//            "docker.elastic.co/logstash/logstash:8.11.2")
//            .dependsOn(elasticsearchContainer)
//            .withFixedExposedPort(5044, 5044);

    @Test
    void shouldLogToConsole() {
        fail();
    }

    @Test
    void shouldLogToFile() throws IOException {
        LOGGER.info("test");

        String loggedMessage = new String(Files.readAllBytes(Paths.get(logFileName)));
        assertNotNull(loggedMessage);
        assertTrue(loggedMessage.contains("\"host\":"));
        assertTrue(loggedMessage.contains("\"short_message\":"));
        assertTrue(loggedMessage.contains("\"full_message\":"));
        assertTrue(loggedMessage.contains("\"timestamp\":"));
        assertTrue(loggedMessage.contains("\"level\":"));
    }

    @Test
    void shouldLogToSocket() {
        fail();
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.delete(Paths.get(logFileName));
    }
}
