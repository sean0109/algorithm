package main.mypractice.designpattern.factory.ex1.factory;

import main.mypractice.designpattern.factory.ex1.SendType;
import main.mypractice.designpattern.factory.ex1.repository.EmailNotificationService;
import main.mypractice.designpattern.factory.ex1.repository.NotificationService;
import main.mypractice.designpattern.factory.ex1.repository.PushNotificationService;
import main.mypractice.designpattern.factory.ex1.repository.SmsNotificationService;

public class NotificationFactory {

    public static NotificationService getService(SendType type){

        switch (type){
            case EMAIL:
                return EmailNotificationService.of();
            case SMS:
                return SmsNotificationService.of();
            case PUSH:
                return PushNotificationService.of();
            default:
                throw new IllegalArgumentException("invalid notification type : " + type);
        }
    }
}
