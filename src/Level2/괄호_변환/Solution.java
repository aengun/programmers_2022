package Level2.괄호_변환;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().solution("(()())()"));
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        System.out.println(new Solution().solution(")("));
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        System.out.println(new Solution().solution("()))((()"));

        System.out.println(new Solution().solution("(((())))"));

    }

    public String solution(String p) {
        String answer = "";

        answer = recursive(p);

        return answer;
    }

    static String recursive(String p) {

        if ("".equals(p)) return "";
        int index = isBalanced(p);
        System.out.println(index);

        StringBuilder u = new StringBuilder(p.substring(0, index));
        StringBuilder v = new StringBuilder(p.substring(index, p.length()));

        if (isRight(u.toString())) {
            //올바른 괄호 문자열인 경우
            return u.toString() + recursive(v.toString());
        } else {
            //균형잡힌 괄호 문자열인 경우
            StringBuilder sb = new StringBuilder("(");

            sb.append(recursive(v.toString()));
            sb.append(")");
            u.deleteCharAt(0);
            u.deleteCharAt(u.length() - 1);
            sb.append(u.reverse());
            return sb.toString();
        }

    }

    static int isBalanced(String p) {

        Stack<Character> stack = new Stack<>();
        int index = 0;
        int sum = 0;
        if (p.length() == 0) return 0;
        for (int i = 0; i < p.toCharArray().length; i++) {
            if (p.toCharArray()[i] == '(') {
                sum += 1;
                index++;
            } else {
                sum -= 1;
                index++;
            }
            if (sum == 0) return index;
        }

        return index;

    }

    static boolean isRight(String t) {

        Stack<Character> stack = new Stack<>();
        for (Character c : t.toCharArray()) {
            if (stack.size() == 0) {
                stack.push(c);
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else stack.push(c);
        }

        if (stack.size() == 0) return true;
        else return false;

    }

}
