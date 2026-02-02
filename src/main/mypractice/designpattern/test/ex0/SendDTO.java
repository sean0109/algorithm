package main.mypractice.designpattern.test.ex0;

// 전송 데이터 객체 DTO (java bean)
public class SendDTO {

    private String title;
    private String message;
    private String recipient;

    public SendDTO(String title, String message, String recipient) {
        this.title = title;
        this.message = message;
        this.recipient = recipient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    // 객체 불변화, 정적 팩토리 메서드
    public static SendDTO of(SendDTO sendDTO) {
        return new SendDTO(sendDTO.title, sendDTO.message, sendDTO.recipient);
    }
    
    // 데이터 유효성 검사
    public static boolean ValidateCheck(SendDTO sendDTO) {

        if(sendDTO.title == null || sendDTO.title.isEmpty()) {
            return false;
        }else if(sendDTO.message == null || sendDTO.message.isEmpty()) {
            return false;
        }else if(sendDTO.recipient == null || sendDTO.recipient.isEmpty()) {
            return false;
        }
        
        return true;
    }
}
