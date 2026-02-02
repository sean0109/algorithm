package main.mytest;

public class WheelDefects {

    public static String simplify(String input) {
        int length = input.length();

        StringBuilder sb = new StringBuilder();
        Character beforeLetter = input.charAt(0);
        sb.append(beforeLetter);

        for(int i = 1; i < length; i++){

            if(input.charAt(i) == beforeLetter){
                System.out.println("continue_" + i);
                continue;
            }else{
                sb.append(input.charAt(i));
                beforeLetter = input.charAt(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(WheelDefects.simplify("ghhrkkb"));
    }
}
