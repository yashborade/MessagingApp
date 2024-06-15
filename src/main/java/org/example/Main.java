package org.example;


public class Main {
    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue();
        MessageCreation messageCreation = new MessageCreation(messageQueue);
        MessageUsed messageUsed = new MessageUsed(messageQueue);

        Thread producerThread = new Thread(messageCreation);
        Thread consumerThread = new Thread(messageUsed);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            MessageLogger.logError("Thread interrupted: " + e.getMessage());
        }

        MessageLogger.logInfo("Total messages processed successfully: " + messageQueue.getSuccessCount());
        MessageLogger.logInfo("Total errors encountered: " + messageQueue.getErrorCount());
    }
}