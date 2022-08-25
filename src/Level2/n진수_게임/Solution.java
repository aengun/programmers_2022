package Level2.n진수_게임;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";

        int totalCnt = m * t; // n진법씩 t회전할 때 총 문자열의 길이
        System.out.println(totalCnt);
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (sb.toString().length() <= totalCnt) {
            sb.append(Integer.toString(num, n).toUpperCase());
            num++;
        }

        int order = p - 1;
        int cnt = 0;
        String s = sb.toString();
        sb = new StringBuilder();
        while (cnt < t) {
            // answer += s.charAt(order);
            sb.append(s.charAt(order));
            order += m;
            cnt++;
        }

        answer = sb.toString();

        return answer;
    }
}