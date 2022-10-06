package Level3.스티커_모으기;

import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int[] dp = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        if (sticker.length == 1) return sticker[0];

        // 첫번째를 뽑은 경우
        dp[0] = sticker[0];
        if (dp.length > 1) dp[1] = Math.max(dp[0], sticker[1]);
        for (int i = 2; i < dp.length - 1; i++) {
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }

        // 두번째를 뽑은 경우
        dp2[1] = sticker[1];
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
        }
        // System.out.println(Arrays.toString(dp2));
        answer = Math.max(dp[dp.length - 2], dp2[dp2.length - 1]);

        return answer;
    }
}