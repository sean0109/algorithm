package main.mypractice.designpattern.factory.ex0;

public class CoffeeMain {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee(CoffeeType.LATTE);
        System.out.println(coffee.getName());
    }
}
