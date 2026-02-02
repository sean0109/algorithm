package main.mypractice.ocp.ex2;

public class Ex2Main {

    public static void main(String[] args) {
        Engine modelY = Car.createElectricCar("ModelY", CarType.ELECTRIC, 50);
        Car modelX = Car.createElectricCar("ModelY", CarType.ELECTRIC, 50);

        modelY.start();
        modelX.start();

        System.out.println("modelX.getOilLevel() = " + modelX.getOilLevel());
    }
}
