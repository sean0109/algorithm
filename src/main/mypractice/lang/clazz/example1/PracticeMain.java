package main.mypractice.lang.clazz.example1;

import java.util.Scanner;

public class PracticeMain {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // 클래스 생성해서
        Class clazz = VehicleType.valueOf(input.toUpperCase()).makeInstance();

        // (방법1) 생성자로 인스턴스 생성 ( 다형적 참조 이용 )
        Engine engine = (Engine) clazz.getDeclaredConstructor().newInstance();
        engine.run();
    }
}
