package main.mypractice.lang.object.example2;

public class Gold implements DiscountPolicy {

    private final TypeData typeData;

    public Gold() {
        this.typeData = TypeData.GOLD;
    }

    @Override
    public int getDiscountRate() {
        return typeData.getRate();
    }

    @Override
    public int getDiscountPrice(int price) {
        return price * typeData.getRate() / 100;
    }
}
