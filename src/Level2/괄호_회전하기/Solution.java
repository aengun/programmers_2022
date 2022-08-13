package Level2.괄호_회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            String tmp = s.substring(i, s.length()) + s.substring(0, i);
            if (isRight(tmp)) answer++;
        }

        return answer;
    }

    static boolean isRight(String tmp) {

        Stack<Character> stack = new Stack<>();

        for (char c : tmp.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                char top = stack.peek();
                if (top == '(') {
                    if (c == ')') stack.pop();
                    else stack.push(c);
                } else if (top == '{') {
                    if (c == '}') stack.pop();
                    else stack.push(c);
                } else if (top == '[') {
                    if (c == ']') stack.pop();
                    else stack.push(c);
                } else stack.push(c);
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }

    }
}
