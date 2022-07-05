package Level1.문자열_내림차순으로_배치하기;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }

        answer = sb.toString();

        return answer;
    }
}

// import java.util.Arrays;
// import java.util.Collections;
// class Solution {
//     public String solution(String s) {
//         String answer = "";
//         String[] strings = s.split("");
// 		Arrays.sort(strings, Collections.reverseOrder());
// 		for (String st : strings)
// 			answer += st;
//         return answer;
//     }
// }
