package Level2.가장_큰_정사각형_찾기;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{1}}));
    }

    public int solution(int[][] board) {
        int answer = 0;

        //테케1 반례
        if (board.length == 1 && board[0].length == 1 && board[0][0] == 1) return 1;

        int[][] dp = new int[board.length][board[0].length];
        dp[0] = board[0];
        for (int i = 0; i < board.length; i++) {
            dp[i][0] = board[i][0];
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        // for(int i = 0; i < board.length; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        return answer * answer;
    }
}