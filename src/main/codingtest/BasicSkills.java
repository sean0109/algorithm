package main.codingtest;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

// 손코딩 해야 할때, 기본으로 암기해야하는 함수들
public class BasicSkills {

    public static void main(String[] args) {
        //arraysPractice();
        //setPractice();
        //stringPractice();
        //streamPractice();
        collectionTest();
        //stackAndQueue();
        //mathTest();
        //hashMapTest();
        //hashMapTest2();
    }

    // *** HashMap ***
    public static void hashMapTest() {

        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put("Key" + i, i);
        }
        // HashMap 모든 key 값과 Value 값 가져오기
        for(String key : map.keySet()){
            System.out.println("키 : " + key);
        }
        // EntrySet 으로 값 가져오기
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println("key : " + entry.getKey() + " , value: " + entry.getValue());
        }

        map.keySet().stream().forEach(System.out::println);
        Object orDefault = map.getOrDefault("Key90", "Value1");
        System.out.println("orDefault : " + orDefault);

        // HashMap 최대/최소 Key 값 가져오기
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        map2.put(1, 5);
        map2.put(2, 70);
        map2.put(3, 50);

        // Max Key
        Integer maxKey = Collections.max(map2.keySet());
        // Min Key
        Integer minKey = Collections.min(map2.keySet());

        System.out.println("maxKey = " + maxKey);
        System.out.println("minKey = " + minKey);
    }

    // *** HashMap2 ***
    public static void hashMapTest2() {
        // HashMap 준비
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 5);
        map.put(2, 70);
        map.put(3, 50);

        Comparator<Map.Entry<Integer, Integer>> comparator = (e1, e2) -> e1.getValue().compareTo(e2.getValue());

        // Max Value의 key, value
        Map.Entry<Integer, Integer> maxEntry = Collections.max(map.entrySet(), comparator);
        // Min Value의 key, value
        Map.Entry<Integer, Integer> minEntry = Collections.min(map.entrySet(), comparator);
        // 결과 출력
        System.out.println(maxEntry.getKey() + " : " + maxEntry.getValue()); // 2 : 70
        System.out.println(minEntry.getKey() + " : " + minEntry.getValue()); // 1 : 5

    }

    // *** 스택 & 큐 ***
    public static void stackAndQueue() {
        // 큐
        Queue<Integer> queue1 = new ArrayDeque<>();
        for (int i = 1; i <= 10; i ++) {
            queue1.offer(i);
        }
        System.out.println("queue1 : " + queue1);

        // 큐를 리스트로 변환
        List<Integer> List = queue1.stream().toList();
        System.out.println("List : " + List);

        while (!queue1.isEmpty()) {
            System.out.println("queue1.poll() = " + queue1.poll());
        }

        // 덱큐
        Deque<Integer> dequeue1 = new ArrayDeque<>();
        for (int i = 1; i <= 10; i ++) {
            dequeue1.offerLast(i);
        }

        System.out.println("dequeue1 : " + dequeue1);
        while (!dequeue1.isEmpty()) {
            System.out.println("dequeue1.poll() = " + dequeue1.pollFirst());
        }

        // 스택
        Stack<Integer> stack1 = new Stack<>();

        for (int i = 1; i <= 10; i ++) {
            stack1.push(i);
        }
        //stack1.remove(stack1.pop()); // 스택 요소 제거
        System.out.println("stack1 : " + stack1);
        while (!stack1.isEmpty()) {
            System.out.println("stack1.peek() = " + stack1.peek());
            System.out.println("stack1.pop() = " + stack1.pop());
        }
    }

    // *** Collection ***
    private static void collectionTest() {

        StringTokenizer st = new StringTokenizer("apple banana", " ");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 5, 6, 7, 7, 7, 10);

        // List를 배열로 변환
        int[] arr = numbers.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(arr));

        Set<Integer> set = new HashSet<>(numbers);
        System.out.println(set);

        int[] arr2 = {10, 9, 8, 7, 8, 5, 4, 6, 8, 4, 3, 2, 2, 1};

        // 중복을 제거하고, 오름차순 정렬하라. 타입은 배열로
        Integer[] arr3 = Arrays.stream(arr2).sorted().boxed().toArray(Integer[]::new);
        Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(arr3));
        System.out.println("set : " + set2);

        // 바로 TreeSet 으로 변경
        TreeSet<Integer> treeSet = Arrays.stream(arr2).sorted().boxed().collect(Collectors.toCollection(TreeSet::new));
        System.out.println("treeSet : " + treeSet);

        // 스트림 객체로 변환하여, collect 메서드로  변환
        List<Integer> list = Arrays.stream(arr2)   // IntStream
                .boxed()                           // Stream<Integer>
                .sorted()                          // Stream<Integer>
                .collect(Collectors.toCollection(ArrayList::new));

        // iterator
        Set<Integer> set3 = new LinkedHashSet<>(list);
        Iterator<Integer> it = set3.iterator();

        // 인덱스 오름차순 순회
        while (it.hasNext()) {
            System.out.println(it.next());
        }


    }

    // *** Stream 관련 ***
    // 원시타입 Stream은 toArray() 매개변수 없어도 자기 원시 타입 반환. 객체 Stream은 toArray() 는 Object[] 반환
    private static void streamPractice() {
        String[] arr = {"banana", "apple", "cherry", "date"};
        // 글자 오름차순
        Arrays.sort(arr, (s1, s2) -> s1.compareTo(s2));
        System.out.println(Arrays.toString(arr));
    }

    // *** String ***
    private static void stringPractice() {
        // 기본형 변수를 String으로 변환
        Integer a = 10;
        String s = String.valueOf(a);

        // 배열에 저장
        String str = "hello";
        String[] arr = str.split("");
        System.out.println(Arrays.toString(arr));

        // String 대소문자 변환
        String str1 = "test";
        String str2 = str1.toUpperCase();
        System.out.println(str2);

        // char 대소문자 변환
        char c = 'a';
        char c2 = Character.toUpperCase(c);
        System.out.println(c2);

        // 대 소문자 여부 확인
        boolean upperCase = Character.isUpperCase(c);
        System.out.println(upperCase);

        // String , char 인덱스 확인
        String str3 = "hello java world";
        int i = str3.indexOf("a", 8);
        char e = str3.charAt(3);
        System.out.println(" e : " + e);

        // 배열에 있는 문자 합치기
        String[] strArr = {"I", "Love", "You"};
        String output = String.join("", strArr);
        System.out.println(output);
    }

    // *** Set ***
    private static void setPractice() {
        Set<Integer> set = new HashSet<>();
        for (int i = 10; i > 0; i--) {
            set.add(i);
        }
        // set을 배열로 변환
        int[] array = set.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(array));

        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set2.add(String.valueOf(i));
        }
        // set을 트리셋으로
        Set<String> treeSet = new TreeSet<>(set2);
        System.out.println(treeSet);
    }

    // *** Arrays ***
    private static void arraysPractice() {

        int[] arr = {10, 8, 11, 2, 3, 0};
        Arrays.stream(arr).boxed().sorted((o1, o2) -> o2 - o1);

        // 오름차순 {0, 2, 3, 8, 10, 11}
        Arrays.sort(arr);
        System.out.println("Arrays.sort(arr) : " + Arrays.toString(arr));

        // 내림차순 {11, 10, 8, 3, 2, 0} : 먼저 int 배열을 Integer 배열로 변환,
        //Object[] arrInteger = Arrays.stream(arr).boxed().toArray();
        Integer[] arrInteger = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arrInteger, Collections.reverseOrder());
        System.out.println("Integer[] arrInteger : " + Arrays.toString(arrInteger));

        // 배열을 ArrayList로 변환
        List<Integer> list = Arrays.asList(arrInteger); // 기본형 배열을 넣을 수 없다.
        System.out.println("List<Integer> list : " + list);

        // 오름차순 정렬하면 binary search로 특정 값을 찾을 수 있다.
        int find = Arrays.binarySearch(arr, 10);
        System.out.println("find : " + arr[find]);

        // 배열의 특정 범위 자르기
        int[] temp = Arrays.copyOfRange(arr, 0, 3);
        System.out.println("int[] temp : " + Arrays.toString(temp));
    }

    // *** Math 라이브러리
    public static void mathTest () {
        // 1. 최대 최소
        int max = Math.max(10, 2);
        int min = Math.min(10, 2);

        // 2. 절대값
        int abs = Math.abs(-10);

        // 3. 올림 내림 반올림
        double ceil = Math.ceil(-3.2);      // -3
        double floor = Math.floor(-3.2);    // -4
        long round = Math.round(-3.26);     // -3	첫째자리에서 반올림

        // 3-1. 소수 둘째, 셋째 자리에서 반올림 하고 싶다면
        double a = 1.23456;
        String b = String.format("%.1f", a);	// .1f는 둘째자리에서 반올림

        // 4. 제곱 제곱근
        double pow = Math.pow(2, 2);// 2^2 = 4
        double sqrt = Math.sqrt(4);// 2

        int powToInt = (int)pow;
        System.out.println("powToInt : " + powToInt);
    }
}
