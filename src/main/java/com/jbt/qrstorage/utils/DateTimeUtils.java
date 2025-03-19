package com.jbt.qrstorage.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor(access = AccessLevel.NONE)
public class DateTimeUtils {

    public static Date addSeconds(Date date, Long seconds) {
        long time = date.getTime();
        time += secondsToMs(seconds);
        date.setTime(time);

        return date;
    }

    public static Date addMinutes(Date date, Long minutes) {
        long time = date.getTime();
        time += minutesToMs(minutes);
        date.setTime(time);

        return date;
    }

    public static Date addHours(Date date, Long hours) {
        long time = date.getTime();
        time += hoursToMs(hours);
        date.setTime(time);

        return date;
    }

    private static Long secondsToMs(Long seconds) {
        return seconds * 1000;
    }

    private static Long minutesToMs(Long minutes) {
        return (minutes * 60) * 1000;
    }

    private static Long hoursToMs(Long hours) {
        return ((hours * 60) * 60) * 1000;
    }

}
