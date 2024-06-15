package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {

    private Queue<Message> queue = new LinkedList<>();
    private int successCount = 0;
    private int errorCount = 0;

    public synchronized void addMessage(Message message) {
        queue.add(message);
        notifyAll();
    }

    public synchronized Message retrieveMessage() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                MessageLogger.logError("Thread interrupted: " + e.getMessage());

            }
        }
        return queue.poll();
    }

    public synchronized void incrementSuccessCount() {
        successCount++;
    }

    public synchronized void incrementErrorCount() {
        errorCount++;
    }

    public int getSuccessCount() {
        return successCount;
    }

    public int getErrorCount() {
        return errorCount;
    }
}
