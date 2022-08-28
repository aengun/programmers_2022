package Level2.피보나치_수;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] fibo = new int[100001];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        answer = fibo[n];

        return answer;
    }
}

// class Solution {
//     public int solution(int n) {
//         int answer = 0;
//         int num1 = 0;
// 		int num2 = 1;

// 		for (int i = 1; i < n; i++) {
// 			answer = num1 + num2;
//             answer%=1234567;
// 			num1 = num2;
// 			num2 = answer;
// 		}

//         return answer;
//     }
// }