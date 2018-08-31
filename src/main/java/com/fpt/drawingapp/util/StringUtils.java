package com.fpt.drawingapp.util;

public final class StringUtils {
    private StringUtils() {}

    public static boolean isNotEmpty(final String value) {
        return value != null && !value.isEmpty();
    }
}
