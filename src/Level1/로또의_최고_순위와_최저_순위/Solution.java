package Level1.로또의_최고_순위와_최저_순위;

import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Set<Integer> win_set = new HashSet<Integer>();
        for (int i : win_nums) {
            win_set.add(i);
        }

        int numOfZero = 0;
        Set<Integer> lotto_set = new HashSet<Integer>();
        for (int i : lottos) {
            if (i == 0) numOfZero++;
            lotto_set.add(i);
        }

        int numOfSame = 0;
        for (int i : lotto_set) {
            if (win_set.contains(i)) {
                numOfSame++;
            }
        }

        int min = numOfSame;
        int max = numOfSame + numOfZero;

        answer[0] = max; //우선 맞은 개수를 넣어둠
        answer[1] = min;

        for (int i = 0; i < answer.length; i++) {
            int tmp = answer[i];
            switch (tmp) {
                case 6:
                    tmp = 1;
                    break;
                case 5:
                    tmp = 2;
                    break;
                case 4:
                    tmp = 3;
                    break;
                case 3:
                    tmp = 4;
                    break;
                case 2:
                    tmp = 5;
                    break;
                default:
                    tmp = 6;
                    break;
            }
            answer[i] = tmp;
        }

        return answer;
    }
}