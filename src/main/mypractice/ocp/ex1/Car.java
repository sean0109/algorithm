package main.mypractice.ocp.ex1;

// 잘못된 설계
public class Car implements Engine {

    private static Car OILCAR;
    private static Car ELECTRICCAR;

    private final String model;
    private int chargeLevel;  // 전기자동차일 경우
    private int oilLevel;     // 연료 자동차일 경우

    private Car(String model, int chargeLevel, int oilLevel) {
        this.model = model;
        this.chargeLevel = chargeLevel;
        this.oilLevel = oilLevel;
    }

    // 정적 팩토리 메소드 (전기자동차 인스턴스 생성)
    public static Car createElectronic(String model, int chargeLevel) {
        ELECTRICCAR = new Car(model, chargeLevel, 0);
         return ELECTRICCAR;
    }

    // 정적 팩토리 메소드 (연료자동차 인스턴스 생성)
    public static Car createOil(String model, int oilLevel) {
        OILCAR = new Car(model, 0, oilLevel);
        return OILCAR;
    }

    public void setChargeLevel(int chargeLevel) {
        this.chargeLevel = chargeLevel;
    }

    public void setOilLevel(int oilLevel) {
        this.oilLevel = oilLevel;
    }
    
    // 자동차 시동 걸기
    // 잘못 된 설계
    @Override
    public void start() {
        System.out.println("충전레벨 확인 : " + chargeLevel);
        System.out.println("연료레벨 확인 : " + oilLevel);
        try{
            if(this == OILCAR){
                System.out.println("연료차 입니다.");
                if(oilLevel <= 0){
                    throw new RuntimeException("연료가 부족합니다.");
                }
            }else if(this == ELECTRICCAR){
                System.out.println("전기차 입니다.");
                if(chargeLevel <= 30){
                    throw new RuntimeException("전기 충전이 부족합니다.");
                }
            }
            System.out.println(model + "의 엔진을 구동합니다.");
        }catch(RuntimeException e){
            e.printStackTrace();
        }
    }
}
