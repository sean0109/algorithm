package main.mypractice.lang.object.example2plus;

// 수동 DI 방식으로 설계
public class DiscountService {

    private final DiscountPolicy discountPolicy;

    // 수동 의존성 주입 DI
    public DiscountService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public int getDiscountRate(){
        return discountPolicy.getDiscountRate();
    }

    public int getDiscountPrice(int price){
        return discountPolicy.getDiscountPrice(price);
    }
    
    // 비지니스 로직 (상품 주문)
    public int orderProcess(){
        // 상품 주문 코드 작성...



        return 0;
    }


}
