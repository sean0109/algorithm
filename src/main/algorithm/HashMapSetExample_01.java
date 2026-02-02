package main.algorithm;

import java.util.*;

public class HashMapSetExample_01 {

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};


        Map<String, Integer> wordCount = new HashMap<String, Integer>();

        for(String word : words ){
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for(String key : wordCount.keySet()){
           System.out.println(key + ": " + wordCount.get(key));

        }

        // HashSet => 중복을 허용하지 않음
        int [] nums = {1, 2, 3, 2, 1, 4, 5};

        Set<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }

        System.out.println("중복 제거 후 : " + set);

        // 값 존재 여부 확인 (HashSet 활용)
        Set<String> dictionary = new HashSet<String>();

        dictionary.add("apple");
        dictionary.add("banana");
        dictionary.add("orange");

        String input = "banana";

        if(dictionary.contains(input)){
            System.out.println(input + " 은(는) 존재합니다.");
        } else {
            System.out.println(input + " 은(는) 존재하지 않습니다.");
        }

        // Map 정렬 (사전순)

        Map<String, Integer> fruitMap = new HashMap<>();
        fruitMap.put("banana", 2);
        fruitMap.put("apple", 3);
        fruitMap.put("orange", 1);

        List<String> fruitList = new ArrayList<>(fruitMap.keySet());

        Collections.sort(fruitList);

        for(String key : fruitList){
            System.out.println(key + ": " + fruitMap.get(key));
        }

        // TreeSet (자동 정렬되는 Set)
        Set<Integer> sortedSet = new TreeSet<Integer>();

        sortedSet.add(5);
        sortedSet.add(2);
        sortedSet.add(8);
        sortedSet.add(8);
        sortedSet.add(1);

        System.out.println("자동 정렬된 결과 : " + sortedSet);

    }
}
