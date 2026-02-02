package main.mypractice.designpattern.factory.ex1review.dto;

/*
Code Review
    1. NPE 위험: checkData()에서 title.isEmpty()를 null 체크보다 먼저 호출 → NPE 가능.
    2. 네이밍 불일치: 필드는 sendMessage인데 setter는 setMessage() / 생성자 파라미터도 message → 혼란 유발.
    3. 가변 DTO: setter가 열려있어 변경 추적/스레드 안전성/검증 일관성에 취약.
    4. 검증 책임 위치: DTO 내부에서 boolean만 리턴 → 실패 원인을 잃음(어떤 필드가 문제인지 불명확).
    5. 패키지 위치: domain이라 되어 있는데 “DTO”면 보통 …dto 패키지로 분리하는 편.
    6. 확장성: 이메일/전화번호 등 recipient 형식이 채널별로 달라질 가능성 → 최소한의 포맷 검증 여지 고려.
*/

public class SendDTO {

    private String title;
    private String message;
    private String recipient;

    public SendDTO(String title, String message, String recipient) {
        this.title = title;
        this.message = message;
        this.recipient = recipient;
        validate();      // 생성 시점에 1차 검증
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        validate();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        validate();
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
        validate();
    }

    private void validate() {
        if(isBlank(title)){
            throw new IllegalArgumentException("title is blank");
        }
        if(isBlank(recipient)){
            throw new IllegalArgumentException("recipient is blank");
        }
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

}
