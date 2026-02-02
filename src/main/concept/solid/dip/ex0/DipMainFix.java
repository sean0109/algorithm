package main.concept.solid.dip.ex0;

public class DipMainFix {
    public static void main(String[] args) {
        System.out.println("의존 역전 원칙을 잘 지킨 설계 예시 ex0");
    }
}

// 컴퓨터 클래스
class ComputerV2 {

    InputDevice device;

    public ComputerV2(InputDevice device) {
        this.device = device;
    }

    public String getInputSignal(){
        return device.getInput();
    }

/*
    상위 모듈인 컴퓨터는 하위 모듈 InputDevice에 의존하지 않는다.
    즉, 구체적인 클래스에 의존하지 말고, 인터페이스나 추상 클래스에 의존한다.
    컴퓨터는 하위 모듈의 구현 클래스를 몰라도 된다.
    이것은 결합도가 낮다는 것을 의미하고, 유연한 설계를 의미한다.
*/
}

// 장비 인터페이스
interface InputDevice {

    String getInput();
}

// 마우스 (impl 장비)
class Mouse implements InputDevice {
    @Override
    public String getInput() {
        return "마우스 클릭";
    }
}

// 키보드 (impl 장비)
class KeyboardV2 implements InputDevice {
    @Override
    public String getInput() {
        return "키보드 입력";
    }
}

// 터치패드 (impl 장비)
class TouchPad implements InputDevice {
    @Override
    public String getInput() {
        return "터치패드 사용";
    }
}
