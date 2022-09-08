package Level2_다시풀기.올바른_괄호;

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        char[] arr = s.toCharArray();

        for (char c : arr) {
            if (stack.isEmpty() || c == '(') stack.push(c);
            else {
                if (stack.peek() == '(' && c == ')') stack.pop();
                else stack.push(c);
            }
        }

        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}