package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageQueueTest {

    @Test
    public void testAddMessage() {
        MessageQueue messageQueue = new MessageQueue();
        Message message = new Message("Test message");
        messageQueue.addMessage(message);
        assertEquals("Test message", messageQueue.retrieveMessage().getContent());
    }

    @Test
    public void testSuccessCount() {
        MessageQueue messageQueue = new MessageQueue();
        messageQueue.incrementSuccessCount();
        assertEquals(1, messageQueue.getSuccessCount());
    }

    @Test
    public void testErrorCount() {
        MessageQueue messageQueue = new MessageQueue();
        messageQueue.incrementErrorCount();
        assertEquals(1, messageQueue.getErrorCount());
    }
}
