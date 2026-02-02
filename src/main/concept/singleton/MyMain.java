package main.concept.singleton;

public class MyMain {

    public static void main(String[] args) {
        // 싱글톤이므로 외부에서 접근 못함
        //MySingleton mySingleton = new MySingleton();

        // 최초 한번 생성된 인스턴스에 접근하려면
        MySingleton mysingleton = MySingleton.getInstance();

        // 정보를 가진 싱글톤 객체 접근
        AppConfig appConfig = AppConfig.getInstance();

        System.out.println("dbUrl : " + appConfig.getDbUrl());
        System.out.println("apiKey : " + appConfig.getApiKey());

        appConfig.setDbUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        appConfig.setApiKey("ORCALE-API-KEY");

        System.out.println("dbUrl : " + appConfig.getDbUrl());
        System.out.println("apiKey : " + appConfig.getApiKey());

    }
}
