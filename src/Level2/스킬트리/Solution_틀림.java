package Level2.스킬트리;

import java.util.*;

class Solution_틀림 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        ArrayList<Character> list = new ArrayList<>();

        for (char c : skill.toCharArray()) {
            list.add(c);
        }

        int[] check = new int[list.size()];
        for (String s : skill_trees) {

            char[] tree = s.toCharArray();
            int checkIndex = 0;

            for (int i = 0; i < check.length; i++) {
                check[i] = -1;
            }

            for (char c : tree) {
                int index = list.indexOf(c);
                if (index != -1) {
                    check[checkIndex++] = index;
                }
            }

            boolean flag = true;
            System.out.println(Arrays.toString(check));

            if (check[0] != 0) {
                flag = false;
            } else {
                for (int i = 0; i < check.length - 1; i++) {
                    if (check[i + 1] == -1) break;
                    if (check[i] > check[i + 1]) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) answer++;

        }

        return answer;
    }
}