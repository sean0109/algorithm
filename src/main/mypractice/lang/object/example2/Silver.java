package main.mypractice.lang.object.example2;

public class Silver implements DiscountPolicy {

    private final TypeData typeData;

    public Silver() {
        this.typeData = TypeData.SILVER;
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
