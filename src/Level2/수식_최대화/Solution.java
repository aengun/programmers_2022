package Level2.수식_최대화;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("100-200*300-500+20"));
        System.out.println(new Solution().solution("50*6-3*2"));
    }

    static long answer;
    static ArrayList<Long> numList;
    static ArrayList<Character> opList;
    static ArrayList<Character> opKind;
    static boolean[] visited;
    static char[] opOrder;
    static int depth;

    public long solution(String expression) {
        answer = Long.MIN_VALUE;

        char[] arr = expression.toCharArray();

        StringBuilder sb = new StringBuilder();

        numList = new ArrayList<>();
        opList = new ArrayList<>();
        opKind = new ArrayList<>();

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            char tmp = arr[i];
            if ('0' <= tmp && tmp <= '9') {
                sb.append(tmp);
            } else {
                opList.add(tmp);
                numList.add(Long.parseLong(sb.toString()));
                set.add(tmp);
                sb = new StringBuilder();
            }
        }

        numList.add(Long.parseLong(sb.toString()));

        opKind = new ArrayList<>(set);
        depth = opKind.size();
        visited = new boolean[depth];
        opOrder = new char[depth];

        Permu(0);

        return answer;
    }

    private void Permu(int L) {

        if (L == depth) {
            Calc();
        } else {

            for (int i = 0; i < depth; i++) {
                if (!visited[i]) {
                    opOrder[L] = opKind.get(i);
                    visited[i] = true;
                    Permu(L + 1);
                    visited[i] = false;
                }
            }

        }

    }

    private void Calc() {

        ArrayList<Long> tmpNumList = new ArrayList<>(numList);

        ArrayList<Character> tmpOpList = new ArrayList<>(opList);

        for (char c : opOrder) {
            for (int i = 0; i < tmpOpList.size(); i++) {
                if (c == tmpOpList.get(i)) {
                    tmpNumList.set(i, Operation(tmpNumList.get(i), tmpNumList.get(i + 1), c));
                    tmpOpList.remove(i);
                    tmpNumList.remove(i + 1);
                    i--;
                }
            }
        }

        answer = Math.max(answer, Math.abs(tmpNumList.get(0)));

    }

    private long Operation(long a, long b, char c) {
        if (c == '*') return a * b;
        else if (c == '+') return a + b;
        else return a - b;
    }


}