package main.concept.solid.lsp.ex0;

public class Square extends Rectangle {
/*
    Square은 정사각형 Rectangle은 직사각형이다.
    정사각형은 4변의 길이가 모두 같으므로, Height, Width의 구분이 없다.
    그래서 개발자는 아래와 같이 구현했다.
    정사각형의 정의에 맞게
    오버라이드한 직사각형 객체의 메서드에서 높이값을 set 하는 setHeight 에서도 height와 width를,
    폭의 값을 set 하는 setWidth 에서도 width와 height를 동시에 세팅해 주도록 구현헀다.

    이렇게 클래스를 설계 했더니, 문제가 생겼다. LspMain 참조.
*/
    
        
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);     // 리스코프 치환 원칙 위배 ( 부모의 의도가 잘못 해석되어 오버라이딩 되었다.)
    }

    @Override
    public void setWidth(int width) {
        super.setHeight(width);
        super.setWidth(width);      // 리스코프 치환 원칙 위배 ( 부모의 의도가 잘못 해석되어 오버라이딩 되었다.)
    }
}
