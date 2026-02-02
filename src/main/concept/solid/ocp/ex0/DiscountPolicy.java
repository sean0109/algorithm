package main.concept.solid.ocp.ex0;

public interface DiscountPolicy  {
    int getDiscountRate();
    int getDiscountPrice(int price, Grade grade);
}
