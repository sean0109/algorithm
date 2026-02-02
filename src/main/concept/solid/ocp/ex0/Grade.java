package main.concept.solid.ocp.ex0;

public enum Grade implements DiscountPolicy {
    BASIC(10),
    SILVER(20),
    GOLD(30),
    PLATINUM(40),
    VIP(50);

    private int discountPercent;

    Grade(int percent) {
        this.discountPercent = percent;
    }

    @Override
    public int getDiscountRate() {
        return discountPercent;
    }

    @Override
    public int getDiscountPrice(int price, Grade grade) {
        return price * discountPercent / 100;
    }

    @Override
    public String toString() {
        return "Grade{ Grade = " + this.name() + " / " +
                "discountPercent=" + discountPercent +
                '}';
    }
}
