package Level2.가장_큰_수;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        List<String> answerList = new ArrayList<>();

        for (int i : numbers) {
            answerList.add(Integer.toString(i));
        }

        // 두개씩 합쳐서 정렬한다. ex) 3, 30 >> 330 / 303
        Collections.sort(answerList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        for (String s : answerList) {
            answer += s;
        }
        // 반례 : [0,0,0,0] 인 경우 "0"이 나와야함
        if (answer.charAt(0) == '0') {
            answer = "0";
        }

        return answer;
    }
}

//=================================================================================

//class Solution {
//    public String solution(int[] numbers) {
//        String answer = "";
//        String k[] = new String[numbers.length];
//        for (int i = 0; i < k.length; i++) {
//            k[i] = "" + numbers[i];
//        }
//
//        Arrays.sort(k, new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                return (o2 + o1).compareTo(o1 + o2);
//            }
//
//        });
//
//        for (int i = 0; i < k.length; i++) {
//            answer += k[i];
//        }
//
//        if (answer.charAt(0) == '0') {
//            answer = "0";
//        }
//        return answer;
//    }
//}