package Level3.야근_지수;

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i : works) {
            sum += i;
            pq.add(i);
        }

        if (sum <= n) return 0;

        while (n > 0) {
            int tmp = pq.poll();
            tmp -= 1;
            pq.add(tmp);
            n--;
        }

        for (int i : pq) {
            answer += i * i;
        }

        return answer;
    }
}