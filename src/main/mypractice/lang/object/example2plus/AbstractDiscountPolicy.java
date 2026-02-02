package main.mypractice.lang.object.example2plus;

public abstract class AbstractDiscountPolicy implements DiscountPolicy {

    private final TypeData typeData;

    public AbstractDiscountPolicy(TypeData typeData) {
        this.typeData = typeData;
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
