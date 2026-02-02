package main.concept.solid.lsp.ex1;

public class WrongImplements {
    public static void main(String[] args) {
        System.out.println("리스코프 치환 원칙을 지키지 못한 설계 예시 ex1");
    }
}

// 부모개체의 상속은 자식개체에서 오버라이드 될때, 의미적으로 맞아야 한다.
interface Bird {
    void fly();
}

class Sparrow implements Bird {
    @Override
    public void fly() {

    }
}

// 펭귄은 날 수 없으므로, Bird를 상속하는것이 의미적으로 맞지 않다.
// 설계 의도에 위배 되었다.
class Penguin implements Bird {
    @Override
    public void fly() {

    }
}
