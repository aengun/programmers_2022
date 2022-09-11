package Level2_다시풀기.숫자의_표현;

class Solution {
    public int solution(int n) {
        int answer = 0;

        if (n == 1) return 1;
        if (n == 2) return 1;

        int left = 1;
        int right = 2;

        int sum = 3;

        while (left <= right) {
            if (sum == n) {
                answer++;
                right++;
                sum += right;
            } else if (sum > n) {
                sum -= left;
                left++;
            } else { // sum < n
                right++;
                sum += right;
            }
        }

        return answer;
    }
}