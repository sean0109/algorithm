package main.mypractice.designpattern.factory.ex1.repository;

import main.mypractice.designpattern.factory.ex1.domain.SendDTO;
import main.mypractice.designpattern.factory.ex1.exception.SendException;

public class EmailNotificationService implements NotificationService {

    private String smtpHost;

    public EmailNotificationService(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public static EmailNotificationService of() {
        return new EmailNotificationService("");
    }

    @Override
    public void send(SendDTO sendData) {

        if(!sendData.checkData()){
            throw new SendException("Email 전송 실패", sendData);
        }

        System.out.println("smtpHost : " + smtpHost);
        System.out.println("Email 전송 시작...");

    }
}
