package Level2.하노이의_탑;

import java.util.*;

class Solution {

    static ArrayList<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        int[][] answer = {};

        hanoi(n, 1, 2, 3);

        // for(int[] i : list){
        //     System.out.println(Arrays.toString(i));
        // }

        answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }

        return answer;
    }

    public static void hanoi(int n, int from, int via, int to) {
        int[] move = new int[]{from, to};
        if (n == 1) {
            list.add(move);
        } else {
            hanoi(n - 1, from, to, via);
            list.add(move);
            hanoi(n - 1, via, from, to);
        }

    }
}