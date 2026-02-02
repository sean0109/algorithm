package main.codingtest.baekjoon.silver;

/* 나는야 포켓몬 마스터 이다솜 : List로 풀기  / 시간 제한 2 초*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_tier4_1620 {
    
    // 시간 초과 indexOf 사용 시 시간복잡도 증가
    private void solve_1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputCnt = Integer.parseInt(st.nextToken());
        int solveCnt = Integer.parseInt(st.nextToken());

        List<String> pokeList = new ArrayList<String>();

        for(int i = 0; i < inputCnt; i++) {
            pokeList.add(br.readLine());
        }

        for (int i = 0; i < solveCnt; i++) {
            String inputData = br.readLine();
            if(Character.isDigit(inputData.charAt(0))) {
                sb.append(pokeList.get(Integer.parseInt(inputData) - 1));   // index는 0번부터이므로 1 빼줌

            }else{
                sb.append(pokeList.indexOf(inputData) + 1);   // 여기선 1을 더함
            }

            if(i < inputCnt - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    // 자료구조 두개 만들어서 해결
    private void bestSolve() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int inputCnt = Integer.parseInt(st.nextToken());
        int solveCnt = Integer.parseInt(st.nextToken());

        Map<String, Integer> pokeName = new HashMap<String, Integer>();
        Map<Integer, String> pokeNum = new HashMap<Integer, String>();

        for(int i = 1; i <= inputCnt; i++) {
            String inputData = br.readLine();
            pokeName.put(inputData, i);
            pokeNum.put(i, inputData);
        }

        for (int i = 0; i < solveCnt; i++) {
            String inputData = br.readLine();
            if (Character.isDigit(inputData.charAt(0))) {
                sb.append(pokeNum.get(Integer.parseInt(inputData)));

            } else {
                sb.append(pokeName.get(inputData));
            }
            if (i < solveCnt - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }


    /* 객체 지향 설계 풀이*/
    // 포켓몬 도감
    private static class PokeDex{
        Map<String, Integer> nameToNumber;
        Map<Integer, String> numberToName;

        // 참조값을 공유하지 않도록, 외부에서 값 변경 불가하도록 불변 으로 설계
        PokeDex(Map<String, Integer> nameToNumber, Map<Integer, String> numberToName) {
            this.nameToNumber = new HashMap<>(nameToNumber);
            this.numberToName = new HashMap<>(numberToName);
        }

        Map<Integer, String> getNumberToName() {
            return new HashMap<>(numberToName);
        }

        Map<String, Integer> getNameToNumber() {
            return new HashMap<>(nameToNumber);
        }

        Object findAny(Object nameOrNumber) throws IOException {

            if(nameOrNumber instanceof Integer){
                return numberToName.get(nameOrNumber);
            }else if(nameOrNumber instanceof String){
                return nameToNumber.get(nameOrNumber);
            }else{
                throw new IOException("데이터 입력 형식이 잘못되었습니다.");
            }
        }

        Integer getNumber(String pokemonNumber) {
            return nameToNumber.get(pokemonNumber);
        }

        String getName(int pokemonName) {
            return numberToName.get(pokemonName);
        }
    }

    private static void oopSolve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToNumber = new HashMap<>();
        Map<Integer, String> numberToName = new HashMap<>();

        for(int i = 1; i < n + 1; i++){
            String input = br.readLine();
            nameToNumber.put(input, i);
            numberToName.put(i, input);
        }

        PokeDex pokeDex = new PokeDex(nameToNumber, numberToName);

        for(int i = 0; i < m; i++){
            String input = br.readLine();

            if(Character.isDigit(input.charAt(0))){
                Integer number = Integer.parseInt(input);
                sb.append(pokeDex.findAny(number));
            }else {
                sb.append(pokeDex.findAny(input));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier4_1620().bestSolve();
    }
}
