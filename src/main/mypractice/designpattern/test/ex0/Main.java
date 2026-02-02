package main.mypractice.designpattern.test.ex0;

public class Main {

    // 알림 전송을 호출해 보자
    public static void main(String[] args) {
        // 1. Email로 전송 시
        // 1.1 EmailSend 객체 생성
        Send emailSend = new EmailSend("smtp.gmail.com");
        String title = "제목 예시 입니다.";
        String message = "메세지 예시 입니다.";
        String recipient = "받는 사람의 아이디를 적으세요";

        // 1.2 전송에 필요한 데이터 생성
        SendDTO sendData = new SendDTO(title, message, recipient);

        // 1.3 비지니스 로직 호출
        SendService sendService = new SendService(emailSend, sendData);
        sendService.send(); // 전송


        // 2. 같은 전송 데이터를 sms 로 호출
        Send smsSend = new SmsSend("kakao.send.api.com");
        sendService.setSendMethod(smsSend);
        sendService.send();

    }
}
