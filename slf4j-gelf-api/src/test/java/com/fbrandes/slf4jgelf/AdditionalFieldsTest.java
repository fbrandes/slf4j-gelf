package com.fbrandes.slf4jgelf;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionalFieldsTest {
    @Test
    void testAdd() {
        AdditionalFields additionalFields = new AdditionalFields();
        additionalFields.add("foo", "bar");
        assertEquals(1, additionalFields.getFields().size());

        additionalFields.add("_foo", "bar");
        // should still be 1
        assertEquals(1, additionalFields.getFields().size());

        additionalFields.add("_bar", "foo");
        assertEquals(2, additionalFields.getFields().size());
    }

    @Test
    void testAddAll() {
        AdditionalFields additionalFields = new AdditionalFields();
        additionalFields.addAll(Map.of());
        assertEquals(0, additionalFields.getFields().size());

        additionalFields.addAll(Map.of("foo1", "bar1", "foo2", "bar2", "foo3", "bar3"));
        assertEquals(3, additionalFields.getFields().size());
    }

    @Test
    void testSetFields() {
        AdditionalFields additionalFields = new AdditionalFields();
        additionalFields.setFields(Map.of("foo1", "bar1", "foo2", "bar2"));
        assertEquals(2, additionalFields.getFields().size());
    }
}
