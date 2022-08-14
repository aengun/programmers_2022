package Level2.영어_끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0};

        HashMap<String, Integer> map = new HashMap<>();
        int turn = 1;
        int order = 1;
        String lastWord = words[0];
        map.put(lastWord, 1);
        for (int i = 1; i < words.length; i++) {
            turn++;
            if (turn > n) {
                turn -= n;
                order++;
            }
            String word = words[i];
            map.put(word, map.getOrDefault(word, 0) + 1);
            if (map.get(word) != 1) return new int[]{turn, order};
            if (lastWord.charAt(lastWord.length() - 1) != word.charAt(0)) {
                return new int[]{turn, order};
            }
            lastWord = word;
        }

        return answer;
    }
}