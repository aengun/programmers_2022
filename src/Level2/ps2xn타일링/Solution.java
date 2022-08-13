package Level2.ps2xn타일링;

//22.08.13 다시풀기
class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] arr = new int[60001];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
        }
        answer = arr[n];
        return answer;
    }
}

//class Solution {
//    public int solution(int n) {
//        int answer = 0;
//
//        int dp[] = new int[60001];
//        dp[1] = 1;
//        dp[2] = 2;
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//
//        for (int i = 3; i <= n; i++) {
//            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
//        }
//
//        answer = dp[n];
//
//        return answer;
//    }
//}

// class Solution {
//     public int solution(int n) {
//         int answer = 0;

//         int result1 = 1;
//         int result2 = 2;

//         for(int i = 2;i<n;i++){
//             answer = result1+result2;
//             answer %= 1000000007;
//             result1 = result2;
//             result2 = answer;
//         }

//         return answer;
//     }
// }