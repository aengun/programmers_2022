package Level2_다시풀기.N_Queen;

import java.util.*;

class Solution {
    static int[] chess;
    static boolean[] visited;
    static int answer;

    public int solution(int n) {
        answer = 0;

        chess = new int[n];
        visited = new boolean[n];
        int depth = n;
        permu(depth, 0);

        return answer;
    }

    static void permu(int depth, int L) {
        if (L == depth) {
            answer++;
        } else {
            for (int i = 0; i < depth; i++) {
                if (!visited[i]) {
                    visited[i] = true;

                    if (isPossible(L, i)) {
                        chess[L] = i;
                        permu(depth, L + 1);
                    }

                    visited[i] = false;
                }
            }
        }
    }

    static boolean isPossible(int L, int i) {
        for (int j = 0; j < L; j++) {
            if (Math.abs(L - j) == Math.abs(chess[j] - i)) return false;
        }
        return true;
    }
}
