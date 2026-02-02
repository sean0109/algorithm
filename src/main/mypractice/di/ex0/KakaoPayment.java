package main.mypractice.di.ex0;

// 카카오 결제
public class KakaoPayment implements Payment {

    private int amount;

    // constructor
    public KakaoPayment(int amount) {
        this.amount = amount;
    }

    @Override
    public void pay() {
        // 카카오 결제 로직
        System.out.println(amount + " 원을 결제 합니다.");
    }

    public void couponConfirm(){
        // 카카오톡 만의 로직
    }


}
