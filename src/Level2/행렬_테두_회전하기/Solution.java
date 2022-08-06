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
            int tmp = arr[x1][y1]; // 시작점은 삭제되므로 미리 저장
            int min = tmp;

            // 아래 방향으로 가면서 차례로 값을 채운다
            for (int x = x1; x < x2; x++) {
                arr[x][y1] = arr[x + 1][y1];
                min = Math.min(arr[x + 1][y1], min);
            }

            // 우측 방향
            for (int y = y1; y < y2; y++) {
                arr[x2][y] = arr[x2][y + 1];
                min = Math.min(arr[x2][y + 1], min);
            }

            // 위쪽 방향
            for (int x = x2; x > x1; x--) {
                arr[x][y2] = arr[x - 1][y2];
                min = Math.min(arr[x - 1][y2], min);
            }

            // 좌측 방향
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
