//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");


        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        // ctrl + shift + j : 문자열 합치기
        String profile = "안녕하세요"
                + "Intellij 강의에"
                + "오신것을 환영합니다";

        // alt + shift + 방향키 : 라인 움직이기
        // ctrl + shift + 방향키 : 컴파일 에러가 안나는 범위 안에서 라인 움직이기
        System.out.println("라인 혹은 구문 단위로 이동시킵니다.");

    }
}