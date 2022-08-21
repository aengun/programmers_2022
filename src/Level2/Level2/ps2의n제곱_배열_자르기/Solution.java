package Level2.Level2.ps2의n제곱_배열_자르기;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        int index = 0;
        for (long i = left; i <= right; i++) {
            answer[index++] = (int) Math.max(i / (long) n, i % (long) n) + 1;
        }

        return answer;
    }
}