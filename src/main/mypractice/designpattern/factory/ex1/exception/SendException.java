package main.mypractice.designpattern.factory.ex1.exception;

import main.mypractice.designpattern.factory.ex1.domain.SendDTO;

public class SendException extends RuntimeException {

    private final String sendMessage;
    private final String title;
    private final String recipient;

    public SendException(String exceptionMessage, SendDTO sendDTO) {
        super(exceptionMessage);
        this.sendMessage = sendDTO.getSendMessage();
        this.title = sendDTO.getTitle();
        this.recipient = sendDTO.getRecipient();
    }

    public String getSendMessage() {
        return sendMessage;
    }

    public String getTitle() {
        return title;
    }

    public String getRecipient() {
        return recipient;
    }
}
