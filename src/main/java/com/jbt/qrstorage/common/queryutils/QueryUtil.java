package com.jbt.qrstorage.common.queryutils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.NONE)
public class QueryUtil {

    public static String pathBuilder(String... paths) {
        if (paths == null || paths.length == 0) {
            return "";
        }

        return String.join(".", paths);
    }

}
