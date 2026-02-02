package main.mypractice.designpattern.factory.ex1.service;

import main.mypractice.designpattern.factory.ex1.domain.SendDTO;
import main.mypractice.designpattern.factory.ex1.exception.SendException;
import main.mypractice.designpattern.factory.ex1.repository.NotificationService;

// 전송 비지니스 로직
public class SendService {

    private final NotificationService service;

    public SendService(NotificationService service) {
        this.service = service;
    }
    
    // 전송 로직
    public void send(SendDTO sendData)  {
        try {
            service.send(sendData);
        } catch (Exception e) {
            System.out.println("[예외 확인] : " + e.getMessage());
            throw e;
        }
    }
    
    // 전송 후처리 로직
    public void afterSend(){
        
    }

    // 그 밖에 전송과 관련된 비지니스 로직...
    // 계속...
    // ...(생략)...

}
