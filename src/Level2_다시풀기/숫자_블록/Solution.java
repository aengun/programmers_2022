package Level2_다시풀기.숫자_블록;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = getDivisor(begin);
            begin++;
        }

        return answer;
    }

    public static int getDivisor(long n) {

        if (n == 1) return 0;

        int divisor = 1;

        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && n / i < 10000000) {
                divisor = (int) (n / i);
                break;
            }
        }

        return divisor;

    }
}