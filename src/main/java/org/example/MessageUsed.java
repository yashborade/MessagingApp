package org.example;

public class MessageUsed implements Runnable {

    private MessageQueue messageQueue;

    public MessageUsed(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            Message message = messageQueue.retrieveMessage();
            try {
                processMessage(message);
                messageQueue.incrementSuccessCount();
                MessageLogger.logInfo("Message Used: " + message.getContent());
            } catch (Exception e) {
                messageQueue.incrementErrorCount();
                MessageLogger.logError("Processing message Exception :" + message.getContent() + " - " + e.getMessage());
            }
        }
    }

    private void processMessage(Message message) throws Exception {
        if (message.getContent().contains("error")) {
            throw new Exception("Processing error");
        }
    }
}
