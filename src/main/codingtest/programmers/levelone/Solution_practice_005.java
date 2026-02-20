package main.codingtest.programmers.levelone;

// 크기가 작은 부분문자열
public class Solution_practice_005 {

    public static void main(String[] args) {

        Solution solution = new Solution();

        // 예시 데이터
/*        String t = "500220839878";
        String p = "7";
 */
        // result = 8

        String t = "3141592";
        String p = "271";
        // result = 2

        int result = solution.solution(t, p);

        System.out.println("result : " + result);
    }

    private static class Solution {
        public int solution(String t, String p) {
            int result = 0;
            int length = p.length();

            for (int i = 0; i < t.length() - length; i++) {

                String s1 = t.substring(i, i + length);

                if (s1.compareTo(p) <= 0) {
                    result ++;
                }
            }

            return result;
        }
    }
}
