package Level1.정수_내림차순으_배치하기;

import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;

        String num = Long.toString(n);
        String[] arr = num.split("");
        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : arr) sb.append(s);
        answer = Long.parseLong(sb.toString());

        return answer;
    }
}