package Level2.두_큐_합_같게_만들기;

import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.offer((long) queue1[i]);
            sum1 += queue1[i];
            q2.offer((long) queue2[i]);
            sum2 += queue2[i];
        }

        int cnt = 0;

        while (sum1 != sum2) {

            if (sum1 > sum2) {
                long tmp = q1.poll();
                q2.offer(tmp);
                sum1 -= tmp;
                sum2 += tmp;
                cnt++;
            } else {
                long tmp = q2.poll();
                q1.offer(tmp);
                sum2 -= tmp;
                sum1 += tmp;
                cnt++;
            }

            if (cnt >= queue1.length * 4) return -1;

        }

        answer = cnt;

        return answer;
    }
}