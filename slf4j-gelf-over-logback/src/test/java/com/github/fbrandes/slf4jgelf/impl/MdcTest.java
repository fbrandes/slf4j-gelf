package com.github.fbrandes.slf4jgelf.impl;

import com.github.fbrandes.slf4jgelf.SimpleGelfLogger;
import com.github.fbrandes.slf4jgelf.SimpleGelfLoggerFactory;
import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@Disabled("move this test to new module where binding to log fraaework is  made")
class MdcTest {
    private final SimpleGelfLogger LOGGER = (SimpleGelfLogger) new SimpleGelfLoggerFactory().getLogger(MdcTest.class);

    @Test
    void testMdcInGelfMessage() throws Exception {
        MDC.put("some", "key");

        String loggedMessage = LogInterceptor.copyOut(() -> LOGGER.info("foo"));

        assertTrue(loggedMessage.contains("\"_some\":\"key\""));
    }

    static class LogInterceptor {
        public interface Block {
            void call() throws Exception;
        }

        public static String copyOut(Block block) throws Exception {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(bos, true);
            PrintStream oldStream = System.out;
            System.setOut(printStream);
            try {
                block.call();
            }
            finally {
                System.setOut(oldStream);
            }
            return bos.toString();
        }
    }
}
