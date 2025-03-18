package com.jbt.qrstorage.utils.queryutils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueryUtilUnitTest {

    @Test
    void pathBuilder() {
        assertEquals("first.second.third", QueryUtil.pathBuilder("first", "second", "third"));
    }

    @Test
    void pathBuilder_null() {
        assertEquals("", QueryUtil.pathBuilder());
    }

}