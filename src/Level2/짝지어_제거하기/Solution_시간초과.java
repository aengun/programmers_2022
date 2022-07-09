package Level2.짝지어_제거하기;

import java.util.LinkedList;

class Solution_시간초과 {
    public int solution(String s) {
        int answer = 1;

        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        while (true) {

            boolean flag = true;

            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) == list.get(i + 1)) {
                    list.remove(i + 1);
                    list.remove(i);
                    flag = false;
                    break;
                }
            }

            if (flag) break;

        }

        if (list.size() > 0) answer = 0;

        return answer;
    }
}
