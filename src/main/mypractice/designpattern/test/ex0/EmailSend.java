package main.mypractice.designpattern.test.ex0;

public class EmailSend implements Send {

    private String smtpHost;

    public EmailSend(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    @Override
    public void send() {
        // SMTP 서버 연결 필요
        if(smtpHost == null || smtpHost.isEmpty()) {
            // 오류 처리 구현 예정

        }

        // email 고유 전송 로직 구현 (smtp 연결 등)
    }
}
