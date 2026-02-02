package main.mypractice.designpattern.test.ex0;

public class SmsSend implements Send {

    private String smsApiUrl;

    public SmsSend(String smsApiUrl) {
        this.smsApiUrl = smsApiUrl;
    }

    public void setSmsApiUrl(String smsApiUrl) {
        this.smsApiUrl = smsApiUrl;
    }

    public String getSmsApiUrl() {
        return smsApiUrl;
    }

    @Override
    public void send() {
        // 외부 SMS API 호출 필요
        if(smsApiUrl == null || smsApiUrl.isEmpty()) {
            // 오류 처리 구현 예정
        }

        // sms 고유 전송 로직 구현 (smsApi 연결 등)
    }
}
