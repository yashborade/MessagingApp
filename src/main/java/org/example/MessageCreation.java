package org.example;

public class MessageCreation implements Runnable{

    private MessageQueue messageQueue;

    public MessageCreation(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Message message = new Message(" "+ i);
            messageQueue.addMessage(message);
            MessageLogger.logInfo("Message Created: " + message.getContent());
        }
    }
}
