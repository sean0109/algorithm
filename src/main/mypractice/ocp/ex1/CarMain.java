package main.mypractice.ocp.ex1;

public class CarMain {

    public static void main(String[] args) {
/*
        Car car1 = Car.createElectronic("ModelY", 100);
        Car car2 = Car.createOil("Prius", 50);
        Car car3 = Car.createElectronic("ModelX", 29);

        car1.start();
        System.out.println();
        car2.start();
        System.out.println();
        car3.start();
        System.out.println();
        car1.start();

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
*/

        Car carA = Car.createElectronic("ModelY", 10);  // ELECTRICCAR = carA
        Car carB = Car.createElectronic("ModelX", 90);  // ELECTRICCAR = carB (덮음)

        carA.start(); // ❌ carA는 전기차인데 ELECTRICCAR가 아님 → else 구문으로 빠짐
    }
}
