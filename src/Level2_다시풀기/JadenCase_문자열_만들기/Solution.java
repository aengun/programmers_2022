package Level2_다시풀기.JadenCase_문자열_만들기;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        s = s.toLowerCase();
        String[] arr = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') sb.append(c);
            else if (i == 0) sb.append(Character.toUpperCase(c));
            else {
                if (s.charAt(i - 1) == ' ') sb.append(Character.toUpperCase(c));
                else sb.append(c);
            }
        }

        answer = sb.toString();

        return answer;
    }
}