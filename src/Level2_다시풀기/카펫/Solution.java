package Level2_다시풀기.카펫;

import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        //세로의 길이
        for (int i = 2; i <= yellow / 2; i++) {
            if (yellow % i == 0) list.add(i);
        }

        for (int sero : list) {
            int garo = yellow / sero;
            if (brown == 2 * (sero + garo) + 4) {
                answer = new int[]{garo + 2, sero + 2};
                break;
            }
        }

        return answer;
    }
}