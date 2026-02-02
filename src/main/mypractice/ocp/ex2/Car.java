package main.mypractice.ocp.ex2;

// Enum 타입을 이용한 설계
public class Car implements Engine{

    private final String model;
    private final CarType carType;
    private int oilLevel;
    private int chargeLevel;

    private Car(String model, CarType carType, int oilLevel, int chargeLevel) {
        this.model = model;
        this.carType = carType;
        this.oilLevel = oilLevel;
        this.chargeLevel = chargeLevel;
    }

    public static Car createOilCar(String model, CarType carType, int oilLevel) {
        return new Car(model, carType, oilLevel, 0);
    }

    public static Car createElectricCar(String model, CarType carType, int ChargeLevel){
        return new Car(model, carType, 0, ChargeLevel);
    }

    public String getModel() {
        return model;
    }

    public CarType getCarType() {
        return carType;
    }

    public int getOilLevel() {
        if(carType != CarType.OIL){
            System.out.println("연료 자동차가 아닙니다.");
            return 0;
        }
        return oilLevel;
    }

    public void setOilLevel(int oilLevel) {
        if(carType != CarType.OIL){
            System.out.println("연료 자동차가 아닙니다. 연료를 넣을 수 없습니다.");
            return;
        }
        this.oilLevel = oilLevel;
    }

    public int getChargeLevel() {
        if(carType != CarType.ELECTRIC){
            System.out.println("전기 자동차가 아닙니다.");
            return 0;
        }
        return chargeLevel;
    }

    public void setChargeLevel(int chargeLevel) {
        if(carType != CarType.ELECTRIC){
            System.out.println("전기 자동차가 아닙니다. 전기를 충전할 수 없습니다.");
        }

        this.chargeLevel = chargeLevel;
    }

    @Override
    public void start() {
        // 요구사항 :
        // 시동을 걸 때, 전기 자동차는 chargeLevel이 10 이상, 연료 자동차는 oilLevel이 5 이상 되어야 가능
        // 시동을 걸 때, 차량의 에너지를 -1 감소
        System.out.println("차종 : " + carType);

        switch(carType){
            case OIL:
                System.out.println("연료 레벨 : " + oilLevel);
                if(oilLevel < 5){
                    throw new RuntimeException("연료가 부족합니다.");
                }
                oilLevel --;
                break;

            case ELECTRIC:
                System.out.println("충전 레벨: " + chargeLevel);
                if(chargeLevel < 10){
                    throw new RuntimeException("전기 충전이 부족합니다.");
                }
                chargeLevel --;
                break;
        }
        System.out.println(model + "의 엔진을 구동합니다.");
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", carType=" + carType +
                ", oilLevel=" + oilLevel +
                ", chargeLevel=" + chargeLevel +
                '}';
    }
}
