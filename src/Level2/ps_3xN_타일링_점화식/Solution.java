package Level2.ps_3xN_타일링_점화식;

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;

        if (n % 2 != 0) return 0;

        long[] dp = new long[n + 1];

        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;
        int index = 1;
        for (int i = 6; i <= n; i = i + 2) {
            System.out.println(i);
            dp[i] = dp[i - 2] * 3;

            for (int j = i - 4; j >= 0; j = j - 2) { // 왜 j-=4가 아니라 j-=2인지 모르겠다
                dp[i] += dp[j] * 2;
            }

            dp[i] %= 1000000007;
        }

        answer = (int) dp[n];

        return answer;
    }
}