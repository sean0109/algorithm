package main.concept.solid.ocp.ex1;

public class Main {
    public static void main(String[] args) {
        // 직접 new 해서 쓰는 방식 : 강한 결합
        // 장점 : 간단하고 빠르게 동작. VipDiscountPolicy에 직접 의존하고 있음
        // BasicDiscountPolicy 으로 바꾸고 싶으면? 코드 수정 필요
        DiscountPolicy vipPolicy = new VipDiscountPolicy();
        System.out.println("vipPolicy.getDisCountRate() = " + vipPolicy.getDiscountRate());

        DiscountPolicy basicPolicy = new BasicDiscountPolicy();
        System.out.println("basicPolicy.getDisCountRate() = " + basicPolicy.getDiscountRate());

        // 인터페이스를 생성자로 주입받는 형식 : 약한 결합
        // 실제 구현체는 외부에서 주입되므로, 구현을 모르는 채 사용 가능
        // 나중에 VipDiscountPolicy 등으로 자유롭게 변경 가능
        DiscountService discountService = new DiscountService(basicPolicy);
        System.out.println("discountService.getDiscountPolicy() = " + discountService.getDiscount());

    }
}
