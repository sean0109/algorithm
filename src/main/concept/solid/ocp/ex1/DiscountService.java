package main.concept.solid.ocp.ex1;

public class DiscountService {

    private final DiscountPolicy discountPolicy;
    // DI 의존성 주입
    public DiscountService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public int getDiscount() {
        return discountPolicy.getDiscountRate();
    }
}
