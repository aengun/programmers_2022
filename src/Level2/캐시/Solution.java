package Level2.캐시;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        LinkedList<String> list = new LinkedList<>();

        if (cacheSize == 0) return 5 * cities.length;

        for (String s : cities) {
            s = s.toLowerCase();
            int index = list.indexOf(s);
            if (index == -1) { // mis
                if (list.size() == cacheSize) {
                    list.remove(0);
                }
                list.add(s);
                answer += 5;
            } else { // hit
                list.remove(index);
                list.add(s);
                answer += 1;
            }
        }

        System.out.println(list);

        return answer;
    }
}