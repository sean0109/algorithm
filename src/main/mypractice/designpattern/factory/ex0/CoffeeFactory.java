package main.mypractice.designpattern.factory.ex0;

// 커피 공장
public class CoffeeFactory {

    // 정적 메서드로 설계
    public static Coffee createCoffee(CoffeeType coffeeType) {

        switch (coffeeType) {
            case LATTE :
                return new Latte();
            case ESPRESSO :
                return new Espresso();
            default :
                throw new IllegalArgumentException("invalid coffee type : " + coffeeType);

        }
    }
}
