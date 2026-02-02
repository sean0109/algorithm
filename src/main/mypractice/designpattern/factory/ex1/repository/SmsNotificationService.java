package main.mypractice.designpattern.factory.ex1.repository;

import main.mypractice.designpattern.factory.ex1.domain.SendDTO;
import main.mypractice.designpattern.factory.ex1.exception.SendException;

public class SmsNotificationService implements NotificationService {

    private String smsServerHost;

    public SmsNotificationService(String smsServerHost) {
        this.smsServerHost = smsServerHost;
    }

    public static SmsNotificationService of(){
        return new SmsNotificationService("");
    }

    @Override
    public void send(SendDTO sendData) throws SendException {

        if(!sendData.checkData()){
            throw new SendException("SMS 전송 실패", sendData);
        }

        System.out.println("SMS 서버 호스트 : " + smsServerHost);
        System.out.println("SMS 전송 시작...");


    }
}
