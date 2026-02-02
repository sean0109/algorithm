package main.mypractice.designpattern.factory.ex1.repository;

import main.mypractice.designpattern.factory.ex1.domain.SendDTO;
import main.mypractice.designpattern.factory.ex1.exception.SendException;

public class PushNotificationService implements NotificationService {

    private String pushServerHost;

    public PushNotificationService(String pushServerHost) {
        this.pushServerHost = pushServerHost;
    }

    public static PushNotificationService of(){
        return new PushNotificationService("");
    }

    @Override
    public void send(SendDTO sendData) throws SendException {

        if(!sendData.checkData()){
            throw new SendException("Push 전송 실패", sendData);
        }

        System.out.println("Push 서버 호스트 : " + pushServerHost);
        System.out.println("Push 전송 시작...");
    }
}
