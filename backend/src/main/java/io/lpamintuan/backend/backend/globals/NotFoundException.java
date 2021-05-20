package io.lpamintuan.backend.backend.globals;

import java.util.UUID;

public class NotFoundException extends Exception {
    public  NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String objectName, UUID id) {
        super(generateMessage(id, objectName));
    }

    public NotFoundException(String objectName, String id) {
        super(generateMessage(id, objectName));
    }

    private static String generateMessage(UUID id, String objectName) {
        return objectName + " with id: " + id.toString() + " not found.";
    }

    private static String generateMessage(String id, String objectName) {
        return objectName + " with id: " + id + " not found.";
    }
}
