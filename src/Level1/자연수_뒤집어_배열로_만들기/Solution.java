package Level1.자연수_뒤집어_배열로_만들기;

class Solution {
    public int[] solution(long n) {
        int[] answer = new int[Long.toString(n).length()];

        for (int i = 0; i < answer.length; i++) {
            int k = (int) (n % 10);
            answer[i] = k;
            n /= 10;
        }

        return answer;
    }
}
