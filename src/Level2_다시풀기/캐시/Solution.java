package Level2_다시풀기.캐시;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> list = new LinkedList<>();

        if (cacheSize == 0) return 5 * cities.length;

        for (String s : cities) {
            s = s.toLowerCase();
            if (list.indexOf(s) == -1) {
                //miss인 경우
                if (list.size() < cacheSize) {
                    list.add(s);
                } else {
                    list.remove(0);
                    list.add(s);
                }
                answer += 5;
            } else {
                //hit인 경우
                int index = list.indexOf(s);
                list.remove(index);
                list.add(s);
                answer++;
            }
        }

        // System.out.println(list);

        return answer;
    }
}
