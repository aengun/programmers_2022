package Level3.보석_쇼핑;

import java.util.*;

class Solution {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"AA", "AB", "AC", "AA", "AC"})));
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"XYZ", "XYZ", "XYZ"})));
//        System.out.println(Arrays.toString(new Solution().solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"a", "a", "b"})));
    }

    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<>();
        // 보석 종류의 수를 구하기 위함
        for (String s : gems) {
            set.add(s);
        }

        int numOfGem = set.size();

        HashMap<String, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        map.put(gems[0], 1);

        int min = Integer.MAX_VALUE;

        while (left <= right && right < gems.length - 1) {
            if (map.size() < numOfGem) {
                right++;
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            } else {
                //이외의 경우는 모두 보석의 수와 같다
                if (min > right - left + 1) {
                    min = right - left + 1;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
        }

        return answer;
    }
}