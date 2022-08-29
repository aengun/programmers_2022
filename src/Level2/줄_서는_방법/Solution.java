package Level2.줄_서는_방법;

import java.util.*;

import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();
        long[] factorial = new long[n + 1];
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        answer = new int[n];
        long remain = k - 1;

        for (int i = 0; i < n; i++) {
            long value = (int) (remain / factorial[n - i - 1]);
            remain = (int) (remain % factorial[n - i - 1]);
            answer[i] = list.get((int) value);
            list.remove((int) value);
        }

        return answer;
    }
}