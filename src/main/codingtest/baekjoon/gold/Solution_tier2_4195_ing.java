package main.codingtest.baekjoon.gold;

/* 친구 네트워크 hashMap, hashSet 사용, union-find 알고리즘 , 시간 제한 3초*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_tier2_4195_ing {

    Set<String> findSet;

    private class Network{

        private final Map<String, String> map1 = new HashMap<>();
        private final Map<String, String> map2 = new HashMap<>();

        public Network(String friend1, String friend2) {
            map1.put(friend1, friend2);
            map2.put(friend2, friend1);
        }

        public String getFriend(String friend) {

            String friend1 = (String) map1.get(friend);
            String friend2 = (String) map2.get(friend);
            String rtnFriend="";

            if(friend1 != null && !"".equals(friend1)){
                rtnFriend = friend1;
            }

            if(friend2 != null && !"".equals(friend2)){
                rtnFriend = friend2;
            }
            return rtnFriend;
        }
    }

    private void solve_1() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int loop = Integer.parseInt(br.readLine());
            Map<Integer, Network> netWorks = new HashMap<>();
            for(int j = 0; j < loop; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();
                Network netWork = new Network(friend1, friend2);
                netWorks.put(j, netWork);
                findSet = new HashSet<>();
                findSet.add(friend1);
                findSet.add(friend2);
                findFriends(netWorks, friend1);
                findFriends(netWorks, friend2);
                sb.append(findSet.size() + "\n");
            }
        }
        System.out.println(sb);
    }

    private void findFriends(Map<Integer, Network> netWorks, String friend) {

        Map<Integer, Network> netWorksCopy = new HashMap<Integer, Network>(netWorks);

        for(int key : netWorksCopy.keySet()){
            Network network =  netWorksCopy.get(key);
            String findFriend = network.getFriend(friend);

            if(findFriend != null && !"".equals(findFriend)){
                findSet.add(findFriend);
                netWorksCopy.remove(key);
                findFriends(netWorksCopy, findFriend);
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution_tier2_4195_ing().solve_1();
    }
}