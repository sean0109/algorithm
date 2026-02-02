package main.mypractice.designpattern.test.ex0;

// 알림 전송 비지니스 로직
public class SendService {

    private Send send;
    private SendDTO sendData;

    // DI : 의존 주입
    public SendService(Send send, SendDTO sendData) {
        this.send = send;
        this.sendData = SendDTO.of(sendData);   // 불변화 (정적 팩토리 메서드)
    }

    public void setSendMethod(Send send) {
        this.send = send;
    }

    public void setSendData(SendDTO sendData) {
        this.sendData = SendDTO.of(sendData);
    }

    // 전송
    public boolean send() {

        if(!SendDTO.ValidateCheck(sendData)) {
            // 오류 예외 처리 구현 예정
            return false;
        }
        send.send();

        return true;
    }

    // 전송 관련 다른 비지니스 로직 구현예정 2

    // 전송 관련 다른 비지니스 로직 구현 예정 3


    //.... ( 계속 )

}
