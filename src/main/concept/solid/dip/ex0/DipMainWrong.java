package main.concept.solid.dip.ex0;

/*
    의존 역전 원칙 (DIP: Dependency Inversion Principle)

    "상위 모듈은 하위 모듈에 의존해서는 안 된다. 둘다 추상화에 의존해야 한다."

    즉, 구체적인 클래스에 의존하지 말고, 인터페이스나 추상 클래스 같은 추상화에 의존하라는 뜻
    코드가 변경에 용이하고, 유연성을 가지도록 하는 것이 목적.

*/

public class DipMainWrong {
    public static void main(String[] args) {
        System.out.println("의존 역전 원칙을 지키지 않은 설계 예시 ex0");
    }
}

class Keyboard {

    public String getInput(){
        return "키보드 입력";
    }
}

class Computer {
    private Keyboard keyboard;

    public Computer() {
        this.keyboard = new Keyboard(); // 직접 Keyboard에 의존 (구현 클래스)
    }

    /*
        [문제점]
         1. Computer 클래스는 Keyboard라는 구체 클래스에 직접 의존하고 있음.
         2. Keyboard를 Mouse, TouchPad로 바꾸려면 Computer의 코드를 직ㄷ접 수정해야 함.
         3. 상위 모듈 (Computer)이 하위 모듈(Keyboard)에 의존하는 구존은 DIP 위반
    */
}
