package Level1.삼진법_뒤집기;

class Solution {
    public int solution(int n) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int r = n % 3;
            n /= 3;
            sb.append(r);
        }

        String num = sb.toString();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            answer += Math.pow(3, len - 1 - i) * (num.charAt(i) - '0');
        }

        return answer;
    }
}