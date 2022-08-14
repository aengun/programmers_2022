package Level2.피로도;

import java.util.*;

class Solution {

    static int[] combi;
    static boolean[] visited;
    static int answer;

    public int solution(int k, int[][] dungeons) {
        answer = -1;

        combi = new int[dungeons.length];
        visited = new boolean[dungeons.length];

        for (int i = 1; i <= dungeons.length; i++) {
            DFS(k, i, dungeons, 0);
        }

        return answer;
    }

    public static void DFS(int k, int n, int[][] dungeons, int L) {

        if (L == n) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int index = combi[i];
                if (k >= dungeons[index][0]) {
                    cnt++;
                    k -= dungeons[index][1];
                } else break;
            }
            answer = Math.max(cnt, answer);
            System.out.println();
        } else {
            //순열 만들기
            for (int i = 0; i < dungeons.length; i++) {
                if (visited[i] == false) {
                    visited[i] = true;
                    combi[L] = i;
                    DFS(k, n, dungeons, L + 1);
                    visited[i] = false;
                }
            }
        }

    }
}