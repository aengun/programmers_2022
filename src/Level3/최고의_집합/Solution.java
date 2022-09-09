package Level3.최고의_집합;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        if (s < n) return new int[]{-1};

        int median = s / n;
        int rest = s % n;
        for (int i = 0; i < n - rest; i++) {
            answer[i] = median;
        }
        for (int i = n - rest; i < n; i++) {
            answer[i] = median + 1;
        }

        return answer;
    }
}
