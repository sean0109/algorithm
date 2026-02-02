package main.mypractice.designpattern.factory.ex1;

import main.mypractice.designpattern.factory.ex1.domain.SendDTO;
import main.mypractice.designpattern.factory.ex1.exception.SendException;
import main.mypractice.designpattern.factory.ex1.factory.NotificationFactory;
import main.mypractice.designpattern.factory.ex1.repository.NotificationService;
import main.mypractice.designpattern.factory.ex1.service.SendService;

public class Ex1Main {
    public static void main(String[] args) {

        NotificationService notify = NotificationFactory.getService(SendType.EMAIL);

        SendDTO sendData = new SendDTO("제목입니다.", "내용입니다.", "받는 사람의 ID 입니다.");

        SendService sendService = new SendService(notify);

        //notify.send(sendData);

        try{
            sendService.send(sendData); // 역전 의존 법칙 적용 (수동 의존성 주입)

        }catch(Exception e) {
            exceptionHandler(e);
        }

        System.out.println("전송을 완료 후, 프로그램을 정상 종료 하겠습니다.");

    }

    // 공통 예외 처리
    private static void exceptionHandler(Exception e) {
        // 공통 처리
        System.out.println("사용자 메시지: 죄송합니다. 알 수 없는 문제가 발생했습니다.");
        System.out.println("==개발자용 디버깅 메시지==");
        e.printStackTrace(System.out);      // 스택 트레이스 출력
        //e.printStackTrace();

        if(e instanceof SendException sendEx) {
            StringBuilder sb = new StringBuilder();
            sb.append("sendMessage : ").append(sendEx.getSendMessage()).append("\n")
                    .append("title : ").append(sendEx.getTitle()).append("\n");
            System.out.println(sb);
        }


    }
}
