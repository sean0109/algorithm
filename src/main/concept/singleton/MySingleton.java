package main.concept.singleton;

// 싱글톤 객체 만들기
public class MySingleton {

    // 1. 자신의 객체 생성 (최초 한번)
    private static final MySingleton instance = new MySingleton();

    // 2. 생성자를 private으로 선언해서, 외부에서 접근 못하게 막음. (외부에서 객체 생성이 절대 될 수 없음)
    private MySingleton() {}
    
    // 3. 외부에서 해당 객체의 instance를 꺼낼 수 있게는 해줌
    public static MySingleton getInstance() {
        return instance;
    }
}
