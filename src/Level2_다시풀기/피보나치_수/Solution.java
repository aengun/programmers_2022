package Level2_다시풀기.피보나치_수;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int[] fibo = new int[n + 1];

        fibo[1] = 1;
        fibo[2] = 1;

        for (int i = 3; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        answer = fibo[n];

        return answer;
    }
}