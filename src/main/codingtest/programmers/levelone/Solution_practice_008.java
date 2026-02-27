package main.codingtest.programmers.levelone;

// 문자열 나누기
public class Solution_practice_008 {

    public static void main(String[] args) {

        Solution sol  = new Solution();

/*               s	        result
            "banana"	        3
            "abracadabra"	    6
            "aaabbaccccabba"	3
 */
        int answer = sol.solution("abracadabra");
        System.out.println("answer  : " + answer);
    }
    private static class Solution {
        int result = 0;

        public int solution(String s) {

            doSearch(s);
            return result;
        }

        public void doSearch (String s) {

            if (s.isEmpty()) {
                return;
            }

            char[] charArr = s.toCharArray();

            char x = charArr[0];
            int xCnt = 1;
            int nxCnt = 0;

            for (int i = 1; i < charArr.length; i ++) {

                if (charArr[i] == x) {
                    xCnt ++;
                } else {
                    nxCnt ++;
                }

                if (xCnt == nxCnt) {
                    result ++;
                    // 재귀 호출
                    doSearch(s.substring(i + 1));
                    return;
                }
            }
            result ++;
        }
    }
}
