package Level2.이진_변환_반복하기;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int zeroCnt = 0;
        int changeCnt = 0;
        int len;

        while (!s.equals("1")) {

            len = 0;

            // 0 제거
            char[] arr = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : arr) {
                if (c == '1') {
                    sb.append(c);
                    len++;
                } else zeroCnt++;
            }
            s = sb.toString();

            // 자릿수로 2진법 수 만들기
            sb = new StringBuilder();
            while (len != 0) {
                int i = len % 2;
                sb.append(len % 2);
                len /= 2;
            }
            s = sb.reverse().toString();
            changeCnt++;
        }

        // System.out.println(changeCnt + " / " + zeroCnt);
        answer = new int[]{changeCnt, zeroCnt};
        return answer;
    }
}