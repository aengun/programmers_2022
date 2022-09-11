package Level2_다시풀기.하노이의_탑;

import java.util.*;

class Solution {

    static ArrayList<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        int[][] answer = {};

        hanoi(1, 2, 3, n);
        answer = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void hanoi(int from, int via, int to, int num) {
        int[] move = new int[]{from, to};
        if (num == 1) {
            list.add(move);
        } else {
            hanoi(from, to, via, num - 1);
            list.add(move);
            hanoi(via, from, to, num - 1);
        }

    }

}
