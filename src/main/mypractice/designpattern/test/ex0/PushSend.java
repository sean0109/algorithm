package main.mypractice.designpattern.test.ex0;

public class PushSend implements Send{

    private String pushServerHost;

    public PushSend(String pushServerHost) {
        this.pushServerHost = pushServerHost;
    }

    public void setPushServerHost(String pushServerHost) {
        this.pushServerHost = pushServerHost;
    }

    public String getPushServerHost() {
        return pushServerHost;
    }

    @Override
    public void send() {
        // 내부 푸시 서버 연결 필요
        if(pushServerHost == null || pushServerHost.isEmpty()) {
            // 오류 처리 구현 예정

        }

        // push 고유 전송 로직 구현 (push 서버에 메시지 전달)
    }
}
