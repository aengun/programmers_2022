package Level2_다시풀기.괄호_회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }

        Stack<Character> tmpStack;
        for (int i = 0; i < s.length(); i++) {

            tmpStack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                char cur = q.poll();
                q.offer(cur);
                if (tmpStack.isEmpty()) {
                    tmpStack.push(cur);
                } else {
                    char tmpCur = tmpStack.peek();
                    if (tmpCur == '(' && cur == ')') {
                        tmpStack.pop();
                    } else if (tmpCur == '{' && cur == '}') {
                        tmpStack.pop();
                    } else if (tmpCur == '[' && cur == ']') {
                        tmpStack.pop();
                    } else {
                        tmpStack.push(cur);
                    }
                }
            }
            if (tmpStack.isEmpty()) {
                answer++;
            }
            char first = q.poll();
            q.offer(first);

        }

        return answer;
    }
}