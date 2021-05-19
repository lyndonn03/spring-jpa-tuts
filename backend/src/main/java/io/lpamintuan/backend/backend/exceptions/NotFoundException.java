package io.lpamintuan.backend.backend.exceptions;

import java.util.UUID;

public class NotFoundException extends Exception {
    public  NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String objectName, UUID id) {
        super(generateMessage(id, objectName));
    }

    private static String generateMessage(UUID id, String objectName) {
        return objectName + " with id: " + id.toString() + " not found.";
    }
}
