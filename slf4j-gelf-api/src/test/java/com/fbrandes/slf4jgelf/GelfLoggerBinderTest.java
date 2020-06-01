package com.fbrandes.slf4jgelf;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.*;

class GelfLoggerBinderTest {

    @Test
    void testLogging() {
        Logger logger = GelfLoggerBinder.getInstance().getLoggerFactory().getLogger(GelfLoggerBinderTest.class.getName());
        assertNotNull(logger);
        assertTrue(logger instanceof GelfLoggerAdapter);

        logger.info("dummy message");
    }

    @Test
    void testInstance() {
        GelfLoggerBinder binder = GelfLoggerBinder.getInstance();
        assertNotNull(binder);
        assertNotNull(binder.getLoggerFactory());
        assertEquals(binder.getLoggerFactoryClassStr(), GelfLoggerFactory.class.getName());
    }
}
