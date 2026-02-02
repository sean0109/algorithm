package main.codingtest.programmers.levelone;

import java.util.HashMap;
import java.util.Map;

public class Solution_kakao_intern_01 {

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int [] choices = {5, 3, 2, 7, 5};

        String answer = new Solution_kakao_intern_01().solution_codreReview(survey, choices);
        System.out.println(answer);
    }

    private String solution_codreReview(String[] survey, int[] choices){
        StringBuilder sb = new StringBuilder();
        String answer = "";

        // 성격 유형 검사 결과 저장
        Map<Character, Integer> rslt = new HashMap<>();
        for (char c : "RTCFJMAN".toCharArray()) {
            rslt.put(c, 0);
        }

        // 성격 유형 검사 시작 , 결과 저장
        for(int i = 0; i < survey.length; i++){
            char Atype = survey[i].charAt(0);
            char Btype = survey[i].charAt(1);

            int absScore = Math.abs(choices[i] - 4);        // 점수 절대값
            int score = choices[i] - 4;

            if(score < 0){
                rslt.put(Atype, rslt.get(Atype) + absScore);
            }else if(score > 0){
                rslt.put(Btype, rslt.get(Btype) + absScore);
            }
        }

        char[][] types = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A', 'N'}};

        for(char [] type : types){
            char type1 = type[0];
            char type2 = type[1];

            if(rslt.get(type1) >= rslt.get(type2)){
                sb.append(type1);
            }else{
                sb.append(type2);
            }
        }

        answer = sb.toString();
        return answer;
    }

    private String solution(String[] survey, int[] choices) {

        StringBuilder sb = new StringBuilder();

        // 성격 유형 지표 저장
      //  String[] type = {"R,T", "C,F", "J,M", "A,N"};
        //String [][] type = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};
        String [] type = {"R", "T", "C", "F", "J", "M", "A", "N"};


        Map<String, Integer> rslt = new HashMap();
        for(int i = 0 ; i < 8; i ++){
            rslt.put(type[i], 0);
        }

        for(int i = 0 ; i < survey.length; i++){
            int score = Math.abs(choices[i] - 4);

            if(choices[i] - 4 < 0){
                String key = survey[i].charAt(0) + "";
                if(rslt.get(key)  <= score ){
                    rslt.put(key, score);
                }

            }else if(choices[i] - 4 > 0) {
                String key = survey[i].charAt(1) + "";
                if(rslt.get(key)  <= score ){
                    rslt.put(key, score);
                }
            }
        }

        // 계산
        for(String typeData : type){

            if(rslt.get(typeData.split(",")[0]) >= rslt.get(typeData.split(",")[1])){
                sb.append(typeData.split(",")[0]);
            }else{
                sb.append(typeData.split(",")[1]);
            }
        }

        //System.out.println(sb);

       String answer = sb.toString();
        return answer;
    }

}
