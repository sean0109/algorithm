package main.concept.solid.isp;

/*

@ 인터페이스 분리 원칙을 지키기 위해.
    - 인터페이스는 역할 기반으로 잘게 나누는게 좋다.
    - 그 인터페이스를 사용하는 클라이언트는 누구냐?를 기준으로 설계하자.
    - 너무 쪼개서 오히려 조립이 어려운 인터페이스 지옥이 되지 않도록 균형도 필요.
 */
public class IspMainFix {
    public static void main(String[] args) {
        System.out.println("인터페이스 분리 워칙을 지킨 설계 예시");
    }
}

// 인터페이스를 분리하자
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class SimplePrinter implements Printer {
    @Override
    public void print() {
        System.out.println("Simple printing...");
    }
}

class MultiFunctionPrinter implements Printer, Scanner, Fax {
    @Override
    public void fax() {

    }

    @Override
    public void print() {

    }

    @Override
    public void scan() {

    }
}
