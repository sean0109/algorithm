package main.mypractice.di.ex0;

// 토스 결제
public class TossPayment implements Payment {

    private int amount;

    // Constructor
    public TossPayment(int amount) {
        this.amount = amount;
    }

    @Override
    public void pay() {
        // 토스 결제 로직
        System.out.println("Toss Payment 입니다." + amount + " 원 결제");
    }

    public void toosBenefit(){
        // 토스만의 로직
    }
}
