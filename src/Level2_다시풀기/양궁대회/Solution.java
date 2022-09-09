package Level2_다시풀기.양궁대회;

import java.util.*;

class Solution {

    static int N;
    static int[] aInfo; // 어피치 과녁
    static int[] maxInfo = new int[]{-1};
    static int maxScoreDiff = 0;

    public int[] solution(int n, int[] info) {
        int[] answer = {};

        N = n;
        aInfo = info;
        int[] lInfo = new int[11]; // 라이언 과녁
        dfs(0, lInfo);
        answer = maxInfo;

        if (maxScoreDiff == 0) return new int[]{-1};

        return answer;
    }

    private static void dfs(int L, int[] lInfo) {
        if (L == N) {
            int aScore = 0;
            int lScore = 0;

            for (int i = 0; i < 11; i++) {
                if (aInfo[i] != 0 || lInfo[i] != 0) {
                    if (aInfo[i] >= lInfo[i]) {
                        aScore += 10 - i;
                    } else {
                        lScore += 10 - i;
                    }
                }
            }

            int diff = lScore - aScore;
            if (diff >= maxScoreDiff) {
                maxInfo = lInfo.clone();
                maxScoreDiff = diff;
            }


        } else {
            for (int i = 0; i < 11 && lInfo[i] <= aInfo[i]; i++) {
                lInfo[i]++;
                dfs(L + 1, lInfo);
                lInfo[i]--;
            }
        }
    }
}