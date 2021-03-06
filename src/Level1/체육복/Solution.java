package Level1.체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]] = 0;
        }

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) {
                if (arr[i - 1] == 2) {
                    arr[i - 1]--;
                    arr[i]++;
                    continue;
                }
                if (i != n && arr[i + 1] == 2) {
                    arr[i + 1]--;
                    arr[i]++;
                    continue;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] != 0) answer++;
        }

        return answer;
    }
}