package main.concept.solid.ocp.ex1;

public class BasicDiscountPolicy implements DiscountPolicy {

    private final int discountRate = 10;

    @Override
    public int getDiscountRate() {
        return this.discountRate;
    }
}
