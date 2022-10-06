package Level3.징검다리_건너기;

class Solution_시간초과 {
    public int solution(int[] stones, int k) {
        int answer = 0;

        while (true) {
            int dis = 0;
            for (int i = 0; i < stones.length; i++) {
                if (dis == k) break;
                if (stones[i] != 0) {
                    stones[i]--;
                    dis = 0;
                } else {
                    dis++;
                }
            }
            if (dis == k) break;
            answer++;
        }

        return answer;
    }
}