package main.intellijbasic;

public class Basic_01 {

    // psvm
    public static void main(String[] args) {
        //sout
        System.out.println("Hello World");

        // ctrl + shift + j : 문자열 합치기
        String profile = "안녕하세요"
                + "Intellij 강의에"
                + "오신것을 환영합니다";

        // alt + shift + 방향키 : 라인 움직이기
        // ctrl + shift + 방향키 : 컴파일 에러가 안나는 범위 안에서 라인 움직이기
        System.out.println("라인 혹은 구문 단위로 이동시킵니다.");

        
        // ctrl + p 누르면 생성자의 매개변수 확인 가능
        //EmailSender emailSender = new EmailSender();
    }
}

class EmailSender{
    int id;
    String name;
    String email;

    public EmailSender(String email, String name, int id) {
        this.email = email;
        this.name = name;
        this.id = id;
    }
}

