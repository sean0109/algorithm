package main.mypractice.designpattern.singleton.ex0;

// 싱클톤으로 네트워크 클라이언트를 만들어 보자 ( ENUM 이용)
// 변경 가능 속성을 같는 싱글톤
public class SingletonNetworkClient {
    
    // 1. 자신의 객체 한개를 static 으로 생성
    private static final SingletonNetworkClient instance = new SingletonNetworkClient();
    
    // 필드 변수 (변경 불가는 final)
    private volatile String address;

    // 외부에서 생성 안되도록 막음
    private SingletonNetworkClient() {
        //this.address = "http://192.168.1.10:8080/";
        this.address = AddressData.SERVER_1.getAddress();   // 초기화
    }
    
    // 외부에서 인스턴스를 get 가능 (정적 팩토리 메서드 형식)
    public static SingletonNetworkClient getInstance() {
        return instance;
    }

    public String getAddress() {
        return address;
    }

    public synchronized void setAddress(AddressData addressData) {

        this.address = addressData.getAddress();
    }
}


