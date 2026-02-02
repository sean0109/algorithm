package main.mypractice.lang.object.example2;

public class DependencyInjectionMain {
    public static void main(String[] args) {

        // Bean 생성
        DiscountPolicy dp = new Gold();

        // 의존성 주입 (생성자 주입 DI)
        DiscountService ds = new DiscountService(dp);

        System.out.println("ds.getDiscountRate() = " + ds.getDiscountRate());
        System.out.println("ds.getDiscountPrice(10000) = " + ds.getDiscountPrice(10000));

        ds.orderProcess();  // 상품 주문 서비스 시작
    }
}
