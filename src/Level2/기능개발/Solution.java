package Level2.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        boolean[] ch = new boolean[progresses.length];
        ArrayList<Integer> list = new ArrayList<>();

        int index = 0;

        while (true) {

            boolean flag = true;
            for (boolean b : ch) {
                if (b == false) flag = false;
            }
            if (flag) break;

            int cnt = 0;

            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                }
            }

            for (int i = index; i < progresses.length; i++) {
                if (progresses[index] < 100) break;
                if (progresses[i] >= 100 && ch[i] == false) {
                    cnt++;
                    index++;
                    ch[i] = true;
                }
            }

            if (cnt != 0) list.add(cnt);
        }

        answer = list.stream().mapToInt(m -> m).toArray();

        return answer;
    }
}