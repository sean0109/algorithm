package main.concept.solid.ocp.ex1;

public class VipDiscountPolicy implements DiscountPolicy {

    private final int discountRate = 50;

    @Override
    public int getDiscountRate() {
        return this.discountRate;
    }
}
