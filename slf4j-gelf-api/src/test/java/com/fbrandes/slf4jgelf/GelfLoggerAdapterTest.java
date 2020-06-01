package com.fbrandes.slf4jgelf;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GelfLoggerAdapterTest {
    private static GelfLoggerAdapter logger;
    private static final String DUMMY_LOG = "foo";
    private static final String ONE_ARG_FORMAT = "foo {}", TWO_ARG_FORMAT = "foo {} {}", THREE_ARG_FORMAT = "foo {} {} {}";

    private static final Marker TEST_MARKER = MarkerFactory.getMarker("TEST");

    @BeforeAll
    static void setup() {
        logger = (GelfLoggerAdapter) GelfLoggerBinder.getInstance().getLoggerFactory().getLogger(GelfLoggerAdapterTest.class.getName());
    }

    @Test
    void testInfoLevel() {
        assertTrue(logger.isInfoEnabled());
        assertTrue(logger.isInfoEnabled(TEST_MARKER));

        logger.info(DUMMY_LOG);
        logger.info(TEST_MARKER, DUMMY_LOG);
        logger.info(ONE_ARG_FORMAT, "bar");
        logger.info(TWO_ARG_FORMAT, "bar1", "bar2");
        logger.info(THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.info(DUMMY_LOG, new IllegalArgumentException());
        logger.info(TEST_MARKER, ONE_ARG_FORMAT, "bar");
        logger.info(TEST_MARKER, TWO_ARG_FORMAT, "bar1", "bar2");
        logger.info(TEST_MARKER, THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.info(TEST_MARKER, DUMMY_LOG, new IllegalArgumentException());
    }

    @Test
    void testDebugLevel() {
        assertTrue(logger.isDebugEnabled());
        assertTrue(logger.isDebugEnabled(TEST_MARKER));

        logger.debug(DUMMY_LOG);
        logger.debug(TEST_MARKER, DUMMY_LOG);
        logger.debug(ONE_ARG_FORMAT, "bar");
        logger.debug(TWO_ARG_FORMAT, "bar1", "bar2");
        logger.debug(THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.debug(DUMMY_LOG, new IllegalArgumentException());
        logger.debug(TEST_MARKER, ONE_ARG_FORMAT, "bar");
        logger.debug(TEST_MARKER, TWO_ARG_FORMAT, "bar1", "bar2");
        logger.debug(TEST_MARKER, THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.debug(TEST_MARKER, DUMMY_LOG, new IllegalArgumentException());
    }

    @Test
    void testWarnLevel() {
        assertTrue(logger.isWarnEnabled());
        assertTrue(logger.isWarnEnabled(TEST_MARKER));

        logger.warn(DUMMY_LOG);
        logger.warn(TEST_MARKER, DUMMY_LOG);
        logger.warn(ONE_ARG_FORMAT, "bar");
        logger.warn(TWO_ARG_FORMAT, "bar1", "bar2");
        logger.warn(THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.warn(DUMMY_LOG, new IllegalArgumentException());
        logger.warn(TEST_MARKER, ONE_ARG_FORMAT, "bar");
        logger.warn(TEST_MARKER, TWO_ARG_FORMAT, "bar1", "bar2");
        logger.warn(TEST_MARKER, THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.warn(TEST_MARKER, DUMMY_LOG, new IllegalArgumentException());
    }

    @Test
    void testErrorLevel() {
        assertTrue(logger.isErrorEnabled());
        assertTrue(logger.isErrorEnabled(TEST_MARKER));

        logger.error(DUMMY_LOG);
        logger.error(TEST_MARKER, DUMMY_LOG);
        logger.error(ONE_ARG_FORMAT, "bar");
        logger.error(TWO_ARG_FORMAT, "bar1", "bar2");
        logger.error(THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.error(DUMMY_LOG, new IllegalArgumentException());
        logger.error(TEST_MARKER, ONE_ARG_FORMAT, "bar");
        logger.error(TEST_MARKER, TWO_ARG_FORMAT, "bar1", "bar2");
        logger.error(TEST_MARKER, THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.error(TEST_MARKER, DUMMY_LOG, new IllegalArgumentException());
    }

    @Test
    void testTraceLevel() {
        assertTrue(logger.isTraceEnabled());
        assertTrue(logger.isTraceEnabled(TEST_MARKER));

        logger.trace(DUMMY_LOG);
        logger.trace(TEST_MARKER, DUMMY_LOG);
        logger.trace(ONE_ARG_FORMAT, "bar");
        logger.trace(TWO_ARG_FORMAT, "bar1", "bar2");
        logger.trace(THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.trace(DUMMY_LOG, new IllegalArgumentException());
        logger.trace(TEST_MARKER, ONE_ARG_FORMAT, "bar");
        logger.trace(TEST_MARKER, TWO_ARG_FORMAT, "bar1", "bar2");
        logger.trace(TEST_MARKER, THREE_ARG_FORMAT, "bar1", "bar2", "bar3");
        logger.trace(TEST_MARKER, DUMMY_LOG, new IllegalArgumentException());
    }
}
