package main.concept.solid.isp;

/*
    Interface Segregation Principle
    클라이언트는 자신이 사용하지 않는 메서드에 의존하지 않아야 한다.
    - 로버트 C.마틴

    하나의 덩치 큰 인터페이스에 모든 기능을 다 몰아놓으면 안 되고,
    클라이언트(사용자 클래스) 입장에서 딱 필요한 메서드만 가진 인터페이스를 제공해야 한다.
*/


public class IspMainWrong {
    public static void main(String[] args) {
        System.out.println("인터페이스 분리 원칙을 지키지 못한 설계 예시");
    }
}

interface Machine {
    void print();
    void scan();
    void fax();
}

// 낡은 프린터 객체는 print는 할수 있지만, scan과 fax 전송 기능은 할 수 없다고 가정
class OldPrinter implements Machine {

    @Override
    public void print() {
        // 문제 없음
    }

    @Override
    public void scan() {
        // 억지로 구현 해야 함.
        // 사용하지 않는 기능에 의존하고 있음 - ISP 위반
    }

    @Override
    public void fax() {
        // 억지로 구현해야 함.
        // 사용하지 않는 기능에 의존하고 있음 - ISP 위반
    }
}