package main.algorithm;

import java.util.*;

public class CollectionFramework {

    public static void main(String[] args) {

        // 컬렉션 프레임워크
        // -대량의 데이터를 쉽고 효과적으로 처리할 수 있는 표준화된 방법을 제공하는 클래스

        // Collection 프레임워크의 구조

        // interface Iterable<E>
            // interface  Collection<E> extends Iterable<E>
                // interface List<E> extends Collection
                // interface Set<E> extends Collection<E>
                // interface Queue<E> extends Collection<E>

        // interface Map<Key, Value>


/*
        1. List extends Collection
            - 순서가 있고, 데이터의 중복 허용
            1.1 ArrayList implements List
                - 속도 빠름. 동기화 보장 x 가벼움, 단방향 포인터 구조. 순차적 접근
            1.2 LinkedList implements List
                - 연결 순서 보장, 스택, 큐, 양방향 큐 등에 사용
                - 양방향 포인터 구조로 데이터의 삽입, 삭제가 잦을 경우 효율적
            1.3 Vector implements List
                - ArryList와 동일하게 사용가능하나 동기화를 보장 o
                    1.3.1 Stack extends Vector
                        - LIFO
        
        2. Set extends Collection
            -  중복 허용 하지 않는 데이터의 집합
            2.1 HashSet implements Set
                - 무작위 순서, 효율 좋음
            2.2 LinkedHashSet
                - 넣은 순서대로 값을 담는 Set (순서 유지)
            2.3 TreeSet
                - 값을 담을때 마다 정렬이 되는 Set

        3. Queue extends Collection
            - FIFO 구조
            - 보통 ArrayDeque 또는 LinkedList로 구현

            Queue test = new ArrayDeque();

        4. Map
            - Key & Value 로 이루어진 데이터 집합
            - 순서 유지 않음
            - key는 중복 허용 x
            4.1 HashMap
                - 무작위로 담기는 Map
            4.2 LinkedMap
                - 데이터가 입력될때 순서를 보장
            4.3 TreeMap
                - Key 값에 의해 정렬이 되는 Map
*/
    }
}

