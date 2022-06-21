package Level1.K번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};

        answer = new int[commands.length];

        for (int i = 0; i < answer.length; i++) {
            int[] arr = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = commands[i][0] - 1, k = 0; j < commands[i][1]; j++) {
                arr[k] = array[j];
                k++;
            }
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }

        return answer;
    }
}