package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void testProcessMessageSuccess() {
        MessageQueue messageQueue = new MessageQueue();
        MessageUsed messageUsed = new MessageUsed(messageQueue);
        Message message = new Message("Test message");
        messageQueue.addMessage(message);

        Thread consumerThread = new Thread(messageUsed);
        consumerThread.start();

        try {
            consumerThread.join(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        assertEquals(1, messageQueue.getSuccessCount());
        assertEquals(0, messageQueue.getErrorCount());
    }

    @Test
    public void testProcessMessageError() {
        MessageQueue messageQueue = new MessageQueue();
        MessageUsed messageUsed = new MessageUsed(messageQueue);
        Message message = new Message("Test message with error");
        messageQueue.addMessage(message);

        Thread consumerThread = new Thread(messageUsed);
        consumerThread.start();

        try {
            consumerThread.join(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        assertEquals(0, messageQueue.getSuccessCount());
        assertEquals(1, messageQueue.getErrorCount());
    }
}
