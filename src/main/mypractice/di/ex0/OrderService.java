package main.mypractice.di.ex0;

// 주문 비지니스 로직
public class OrderService {

    private Payment payment;            // 대행사결제
    private CardService cardService;    // 카드사연계

    public OrderService(Payment payment, CardService cardService) {
        this.payment = payment;
        this.cardService = cardService;
    }
    
    // 주문 공통 비지니스 로직
    public void order(){
        // 결제
        payment.pay();

        // 카드사 연계
        cardService.callService();
        
        // 영수증 발행
        
        // 주문 종료

    }

    // 주문 취소
    public void cancelOrder(){
        // 주문 취소 비지니스 로직
    }

    // 주문 확정
    public void confirmOrder(){
        // 주문 확정 비지니스 로직
        
    }
}
