package Level1.신고_결과_받기;

import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, HashSet<String>> map = new HashMap<>(); // 신고자 - 신고 아이디
        // 신고 중복 제거
        for (String s : report) {
            String[] arr = s.split(" ");
            HashSet<String> tmpSet;
            if (map.get(arr[0]) != null)
                tmpSet = map.get(arr[0]);
            else
                tmpSet = new HashSet<String>();
            tmpSet.add(arr[1]);
            map.put(arr[0], tmpSet);
        }

        HashMap<String, Integer> countMap = new HashMap<>();

        for (String i : id_list) {
            if (map.get(i) != null) {
                for (String s : map.get(i)) {
                    countMap.put(s, countMap.getOrDefault(s, 0) + 1);
                }
            }

        }

        Set<String> suspensionSet = new HashSet<>();

        for (String s : id_list) {
            if (countMap.get(s) != null && countMap.get(s) >= k) suspensionSet.add(s);
        }

        for (int i = 0; i < id_list.length; i++) {
            if (map.get(id_list[i]) != null) {
                int cnt = 0;
                for (String name : map.get(id_list[i])) {
                    if (suspensionSet.contains(name)) cnt++;
                }
                answer[i] = cnt;
            }
        }

        return answer;
    }
}