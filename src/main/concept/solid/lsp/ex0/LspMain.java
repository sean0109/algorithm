package main.concept.solid.lsp.ex0;

/*
리스코프 치환 원칙 ( LSP, Liskov Substitution Principle)

    "서브타입은 언제나 자신의 기반 타입으로 대체할 수 있어야 한다. 바바라 리스코프(Barbara Liskov) 1987년"

    - 부모 클래스 (또는 인터페이스)로 객체를 선언하여 하위 클래스의 인스턴스를 받으면,
    업캐스팅 된 상태에서 부모의 메서드를 사용해도 동작이 의도대로만 흘러가도록 구성해야 한다.

 */

public class LspMain {

    public static void main(String[] args) {

        System.out.println("리스코프 치환 원칙을 지키지 못한 설계 예시 ex0");

        Rectangle rectangle = new Rectangle();
        printArea(rectangle);

        Square square = new Square();
        printArea(square);  // 기대값과 다르다. 리스코프 치환 원칙 위배
    }

    public static void printArea(Rectangle r) {
        r.setHeight(5); // 높이 설정
        r.setWidth(10); // 폭 설정
        System.out.println(r.getArea());    // 넓이 출력 : 기대값 50
    }
}
