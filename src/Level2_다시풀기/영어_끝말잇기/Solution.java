package Level2_다시풀기.영어_끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        HashMap<String, Integer> map = new HashMap<>();

        int round = 1;
        int turn = 1;
        char last = words[0].charAt(words[0].length() - 1);
        map.put(words[0], 1);

        for (int i = 1; i < words.length; i++) {
            turn++;


            String s = words[i];

            if (s.charAt(0) != last) break;

            last = s.charAt(s.length() - 1);

            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) != 1) break;

            if (turn == n) {
                turn = 0;
                round++;
            }
        }

        if (round > (words.length / n)) return new int[]{0, 0};
        answer = new int[]{turn, round};

        return answer;
    }
}