package Level2.멀리뛰기;

class Solution {
    public long solution(int n) {
        long answer = 0;

        long one = 1;
        long two = 2;

        if (n == 1) return one;
        if (n == 2) return two;

        for (int i = 3; i <= n; i++) {
            answer = (one + two) % 1234567;
            one = two;
            two = answer;
        }


        //런타임에러
//         long[] dp = new long[n+1];

//         dp[1] = (long)1;
//         dp[2] = (long)2;
//         if(n == 1) return 1;
//         if(n == 2) return 2;
//         for(int i = 3; i <= n; i++){
//             dp[i] = (dp[i-1] + dp[i-2]);
//             dp[i] %= (long)1234567;
//         }

//         answer = dp[n];

        return answer;
    }
}

// class Solution {
//     public long solution(int n) {
//         long answer = 0;

//         long result1 = 1;
// 		long result2 = 2;

// 		if (n == 1)
// 			return result1;
// 		else if (n == 2)
// 			return result2;

// 		for (int i = 2; i < n; i++) {
// 			answer = result1 + result2;
// 			answer %= 1234567;
// 			result1 = result2;
// 			result2 = answer;
// 		}

//         return answer;
//     }
// }