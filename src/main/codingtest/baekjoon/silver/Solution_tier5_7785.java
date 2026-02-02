package main.codingtest.baekjoon.silver;

/*
    문제 : 회사에 있는 사람
    난이도 : 실버 5
    알고리즘 : hashMap 정렬
    시간제한 : 1초
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_tier5_7785 {

    private void solve_1() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        Map<String, String> employee = new HashMap<String, String>();

        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String data = st.nextToken();
            if ("enter".equals(data)) {
                employee.put(name, data);
            } else if ("leave".equals(data)) {
                employee.remove(name);
            }
        }
        List<String> employeeList = new ArrayList(employee.keySet());
        // 사전 순 역순 정렬
        Collections.sort(employeeList, (String o1, String o2) ->o2.compareTo(o1));
        for(int i = 0; i < employeeList.size(); i++) {
            sb.append(employeeList.get(i));
            if(i != employeeList.size() - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    // 코드리뷰 - 트리셋을 써서 실시간 정렬
    private void codeReview() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());
        Set<String> employeeSet = new TreeSet<>(Comparator.reverseOrder());

        for(int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String data = st.nextToken();

            if ("enter".equals(data)) {
                employeeSet.add(name);
            } else if ("leave".equals(data)) {
                employeeSet.remove(name);
            }
        }
        for(String name : employeeSet) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier5_7785().codeReview();
    }
}