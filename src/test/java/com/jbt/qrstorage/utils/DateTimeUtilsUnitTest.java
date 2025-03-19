package com.jbt.qrstorage.utils;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateTimeUtilsUnitTest {

    @Test
    public void addSeconds_addWithoutOverflow() {
        Date startTime = Date.from(Instant.parse("2025-03-19T10:00:00.000000000Z"));
        Date expectedEndTime = Date.from(Instant.parse("2025-03-19T10:00:40.000000000Z"));

        Date actualEndTime = DateTimeUtils.addSeconds(startTime, 40L);

        assertEquals(expectedEndTime, actualEndTime);
    }

    @Test
    public void addSeconds_addWithMinuteOverflow() {
        Date startTime = Date.from(Instant.parse("2025-03-19T10:00:20.000000000Z"));
        Date expectedEndTime = Date.from(Instant.parse("2025-03-19T10:01:00.000000000Z"));

        Date actualEndTime = DateTimeUtils.addSeconds(startTime, 40L);

        assertEquals(expectedEndTime, actualEndTime);
    }

    @Test
    public void addSeconds_addWithHourOverflow() {
        Date startTime = Date.from(Instant.parse("2025-03-19T10:59:20.000000000Z"));
        Date expectedEndTime = Date.from(Instant.parse("2025-03-19T11:00:00.000000000Z"));

        Date actualEndTime = DateTimeUtils.addSeconds(startTime, 40L);

        assertEquals(expectedEndTime, actualEndTime);
    }

    @Test
    public void addMinutes_addWithoutOverflow() {
        Date startTime = Date.from(Instant.parse("2025-03-19T10:00:00.000000000Z"));
        Date expectedEndTime = Date.from(Instant.parse("2025-03-19T10:40:00.000000000Z"));

        Date actualEndTime = DateTimeUtils.addMinutes(startTime, 40L);

        assertEquals(expectedEndTime, actualEndTime);
    }

    @Test
    public void addMinutes_addWithHourOverflow() {
        Date startTime = Date.from(Instant.parse("2025-03-19T10:20:00.000000000Z"));
        Date expectedEndTime = Date.from(Instant.parse("2025-03-19T11:00:00.000000000Z"));

        Date actualEndTime = DateTimeUtils.addMinutes(startTime, 40L);

        assertEquals(expectedEndTime, actualEndTime);
    }

    @Test
    public void addMinutes_addWithDayOverflow() {
        Date startTime = Date.from(Instant.parse("2025-03-19T23:20:00.000000000Z"));
        Date expectedEndTime = Date.from(Instant.parse("2025-03-20T00:00:00.000000000Z"));

        Date actualEndTime = DateTimeUtils.addMinutes(startTime, 40L);

        assertEquals(expectedEndTime, actualEndTime);
    }

    @Test
    public void addHours_addWithoutOverflow() {
        Date startTime = Date.from(Instant.parse("2025-03-19T10:00:00.000000000Z"));
        Date expectedEndTime = Date.from(Instant.parse("2025-03-19T15:00:00.000000000Z"));

        Date actualEndTime = DateTimeUtils.addHours(startTime, 5L);

        assertEquals(expectedEndTime, actualEndTime);
    }

    @Test
    public void addHours_addWithDayOverflow() {
        Date startTime = Date.from(Instant.parse("2025-03-19T23:00:00.000000000Z"));
        Date expectedEndTime = Date.from(Instant.parse("2025-03-20T04:00:00.000000000Z"));

        Date actualEndTime = DateTimeUtils.addHours(startTime, 5L);

        assertEquals(expectedEndTime, actualEndTime);
    }

}