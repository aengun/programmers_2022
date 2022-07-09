package Level2.행렬_테두_회전하기;

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] arr = new int[rows][columns];

        int index = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = index;
                index++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;
            int tmp = arr[x1][y1];
            int min = tmp;

            for (int x = x1; x < x2; x++) {
                arr[x][y1] = arr[x + 1][y1];
                min = Math.min(arr[x + 1][y1], min);
            }

            for (int y = y1; y < y2; y++) {
                arr[x2][y] = arr[x2][y + 1];
                min = Math.min(arr[x2][y + 1], min);
            }

            for (int x = x2; x > x1; x--) {
                arr[x][y2] = arr[x - 1][y2];
                min = Math.min(arr[x - 1][y2], min);
            }

            for (int y = y2; y > y1; y--) {
                arr[x1][y] = arr[x1][y - 1];
                min = Math.min(arr[x1][y - 1], min);
            }

            arr[x1][y1 + 1] = tmp;
            answer[i] = min;

        }

        return answer;
    }
}
