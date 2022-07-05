package Level1.문자열_내_마음대로_정렬하기;

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        ArrayList<String> list = new ArrayList<>();
        for (String s : strings) {
            list.add(s.charAt(n) + s);
        }

        Collections.sort(list);

        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i).substring(1);
        }

        return answer;
    }
}

// import java.util.Arrays;
// class Solution {
//     public String[] solution(String[] strings, int n) {
//         Arrays.sort(strings, (st1, st2) -> {
// 			if (st1.charAt(n) != st2.charAt(n))
// 				return st1.charAt(n) - st2.charAt(n);
// 			else
// 				return st1.compareTo(st2);
// 		});

// 		return strings;
//     }
// }