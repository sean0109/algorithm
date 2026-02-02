package main.concept.singleton;

// AppConfig : 설정 정보에 대한 객체를 싱글톤 패턴으로 설계 하라.
// 디자인패턴 :  Eager initialization (이른 초기화)

/*
1. 비지니스 요구사항 :
 "모든 서비스에서 동일한 설정 값(예: DB 연결 정보, API 키 등)을 공통적으로 사용해야 한다.
 변경은 중앙에서만 되고, 프로그램 전체에서 이 설정을 공유해야 한다."

2. 설계
    - 멤버변수
    AppConfig : 자신의 객체, 변수는 instance로 한다. (jvm의 classLoader에 최초 단 한번 생성)
    dbUrl : 문자
    apiKey : 문자

    - 생성자
    생성자에서 초기 값 세팅.
    dbUrl : "jdbc:mysql://localhost:3306/mydb"
    apiKey : "SECRET-KEY-1234"

    - 싱글톤이므로 외부에서 instance 꺼낼수 있는 메소드  생성
    - 외부에서 dbUrl 접근 및 변경이 가능한 getter, setter 메소드 생성
    - 외부에서 apiKey 접근이 가능한 getter, setter 메소드 생성
*/

public class AppConfig {

    private static final AppConfig instance = new AppConfig();

    private String dbUrl;
    private String apiKey;

    private AppConfig() {
        this.dbUrl = "jdbc:mysql://localhost:3306/mydb";
        this.apiKey = "SECRET-KEY-1234";
    }

    public static AppConfig getInstance(){
        return instance;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
