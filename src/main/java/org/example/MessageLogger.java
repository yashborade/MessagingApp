package org.example;

import java.time.LocalDateTime;

public class MessageLogger {

    public static void logInfo(String message) {
        System.out.println(LocalDateTime.now() + " INFO: " + message);
    }

    public static void logError(String message) {
        System.err.println(LocalDateTime.now() + " ERROR: " + message);
    }
}
