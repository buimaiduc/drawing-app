package com.fpt.drawingapp.util;

import com.fpt.drawingapp.exception.ResourceNotFoundException;

public final class ResourceGuardian {

    private ResourceGuardian() {
    }

    public static void validateNotNull(final Object object, final String message) {
        if (object == null) {
            throw new ResourceNotFoundException(message);
        }
    }

    public static void validate(final String message) {
        throw new ResourceNotFoundException(message);
    }
}