package main.mypractice.designpattern.factory.ex1.domain;

public class SendDTO {

    private String title;
    private String sendMessage;
    private String recipient;

    public SendDTO(String title, String message, String recipient) {
        this.title = title;
        this.sendMessage = message;
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(String message) {
        this.sendMessage = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    
    // 전송 데이터 유효성 검사
    public boolean checkData(){

        if(title == null || title.isEmpty()){
            return false;
        }else if( recipient == null || recipient.isEmpty()){
            return false;
        }
        return true;
    }
}
