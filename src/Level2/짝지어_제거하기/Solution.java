package Level2.짝지어_제거하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) stack.push(c);
            else {
                char tmp = stack.peek();
                if (tmp == c) stack.pop();
                else stack.push(c);
            }
        }

        if (!stack.isEmpty()) answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("abcda"));
    }
}
