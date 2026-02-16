package main.codingtest.programmers.levelone;

// 대충만든 자판
public class Solution_practice_001 {

    public static void main(String[] args) {

        Solution sol = new Solution();

        //String[] keymap = {"ABACD", "BCEFD"};
        //String[] targets = {"ABCD", "AABB"};

        String[] keymap = {"AGZ", "BSSS"};
        String[] targets = {"ASA", "BGZ"};

        sol.solution(keymap, targets);
    }

    private static class Solution {

        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];

            for (int i = 0; i < targets.length; i++) {

                int addIdx = 0;
                boolean findFlag = true;    // 문자열 을 찾았는지 판별

                for (char c : targets[i].toCharArray()) {
                    int findIdx = 100;
                    for (String keys : keymap) {

                        int tmpIdx = keys.indexOf(c);

                        // 찾았을 경우
                        if (tmpIdx != -1) {
                            findIdx = Math.min(findIdx, keys.indexOf(c) + 1);
                        }
                    }
                    // 찾지 못했을 경우
                    if (findIdx == 100) {
                        findFlag = false;
                        break;
                    }
                    addIdx += findIdx;
                }
                answer[i] = findFlag ? addIdx : -1;
            }

            return answer;
        }
    }
}
