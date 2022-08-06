package Level2.가장_큰_수;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//=================================================================================

class Solution_시간초과 {

    static int[] numList;
    static boolean[] visited;
    static List<String> answerList = new ArrayList<>();

    public String solution(int[] numbers) {
        String answer = "";

        numList = new int[numbers.length];
        visited = new boolean[numbers.length];
        Permu(0, numbers);
        Collections.sort(answerList);
        answer = answerList.get(answerList.size()-1);

        return answer;
    }

    public static void Permu(int L, int[] numbers){

        if(L == numbers.length){
            answerList.add(Arrays.toString(numList).replaceAll("[^0-9]",""));
        } else {
            for(int i = 0; i < numbers.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    numList[L] = numbers[i];
                    Permu(L+1, numbers);
                    visited[i] = false;
                }
            }
        }

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