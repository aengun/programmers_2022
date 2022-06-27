package Level1.정수_제곱근_판별;

class Solution {
    public long solution(long n) {
        long answer = 0;

        long root = (int) Math.sqrt(n);
        if (root * root == n) answer = (root + 1) * (root + 1);
        else answer = -1;

        return answer;
    }
}