package main.concept.cohesion;

public class cohesionMain {
    public static void main(String[] args) {
        System.out.println("응집도가 낮은 설계와 응집도가 높은 설계에 대해서 알아보자");
    }
}

/*응집도가 낮은 설계*/
class Utility {
/*
    보고서 출력, 이메일 전송, 세금 계산, 로깅을 모두 담당하는 클래스.
    기능끼리 연관성이 거의없음.
    실제 어플리케이션 구조에선 강한 응집도를 갖는 모듈로 나눠야 함.
*/

    public void printReport() {
        System.out.println("보고서 출력 중...");
    }

    public void sendEmail(String msg) {
        System.out.println("이메일 전송: " + msg);
    }

    public int calculateTax(int price){
        return (int) (price * 0.1);
    }

    public void log(String msg){
        System.out.println("LOG : " + msg);
    }
}

/*응집도가 높은 설계*/
class TaxCalculator {
/*
    오직 세금 계산과 관련된 기능만 집중하고 있음.
    향후에 세금 정책이 바뀌면 이 클래스만 수정하면 됨.
    책임이 하나로 응집되어 있어 유지보수성이 뛰어남.
    (단일 책임 원칙을 잘 지킨 설계)
*/
    public int calculateTax(int price){
        return (int) (price * 0.1);
    }

    public int calculateTotalPrice(int price){
        return price + calculateTax(price);
    }
}


