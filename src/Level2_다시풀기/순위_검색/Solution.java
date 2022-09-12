package Level2_다시풀기.순위_검색;

import java.util.*;

class Solution {

    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // info가 포함될 수 있는 모든 쿼리를 map (key , list)으로 만든다.
        for (String s : info) {
            String[] arr = s.split(" ");
            makeSentence(0, arr, "");
        }

        // 정렬 해야함(이분탐색은 정렬이 된 상태에서 해야한다)
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }

        //이분탐색
        for (int i = 0; i < query.length; i++) {
            String s = query[i];
            s = s.replaceAll(" and ", "");
            String[] arr = s.split(" ");
            answer[i] = binarySearch(arr[0], Integer.parseInt(arr[1]));
        }

        return answer;
    }

    static void makeSentence(int L, String[] arr, String s) {

        if (L == 4) {
            // System.out.println(s);
            if (!map.containsKey(s)) {
                ArrayList<Integer> list = new ArrayList<>();
                map.put(s, list);
            }
            map.get(s).add(Integer.parseInt(arr[4]));
        } else {
            makeSentence(L + 1, arr, s + "-");
            makeSentence(L + 1, arr, s + arr[L]);
        }

    }

    static int binarySearch(String s, int n) {

        if (!map.containsKey(s)) return 0;

        ArrayList<Integer> tmp = map.get(s);
        int left = 0;
        int right = tmp.size() - 1;
        int mid = left;
        while (left <= right) {
            mid = (left + right) / 2;
            if (tmp.get(mid) < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // System.out.println(tmp);
        // System.out.println(n + " " + left);

        return tmp.size() - left;

    }
}