package Level2.괄호_변환;

import java.util.Stack;

public class Solution_못풂 {

    public static void main(String[] args) {

        System.out.println(new Solution_못풂().solution("(()())()"));
        System.out.println(new Solution_못풂().solution(")("));
        System.out.println(new Solution_못풂().solution("()))((()"));

    }

    public String solution(String p) {
        String answer = "";

        if ("".equals(p)) return "";

        StringBuilder u = new StringBuilder(p);
        StringBuilder v = new StringBuilder("");

        while (true) {
            if (isRightBanlanced(u.toString())) {
                answer = u.toString();
                break;
            } else {
                StringBuilder sb = new StringBuilder("(");
                sb.append(v);
                sb.append(")");

            }
        }

        return answer;
    }

    public static boolean isRightBanlanced(String test) {
        Stack<Character> stack = new Stack<>();
        for (char c : test.toCharArray()) {
            if (c == '(' || stack.size() == 0) {
                stack.push(c);
            } else if (stack.peek() == '(') {
                stack.pop();
            }
        }
        if (stack.size() == 0) return true;
        else return false;
    }

//    public static String isBalanced(String test) {
//        StringBuilder sb = new StringBuilder();
//
//        Stack<Character> stack = new Stack<>();
//
//        for (char c : test.toCharArray()) {
//            if (c == '(' || stack.size() == 0) {
//                stack.push(c);
//            } else if (stack.peek() == '(') {
//                stack.pop();
//            }
//        }
//
//    }

}
