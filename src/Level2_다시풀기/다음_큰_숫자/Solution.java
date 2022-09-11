package Level2_다시풀기.다음_큰_숫자;

class Solution {
    public int solution(int n) {
        int answer = 0;

        answer = n;

        String binaryN = Integer.toBinaryString(n);
        int numOfOne = 0;
        for (char c : binaryN.toCharArray()) {
            if (c == '1') numOfOne++;
        }

        while (true) {
            answer++;
            String tmpBinary = Integer.toBinaryString(answer);
            int tmpOne = 0;
            for (char c : tmpBinary.toCharArray()) {
                if (c == '1') tmpOne++;
            }
            if (tmpOne == numOfOne) break;
        }

        return answer;
    }
}