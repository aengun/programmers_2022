package Level2.수식_최대화;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("100-200*300-500+20"));
        System.out.println(new Solution().solution("50*6-3*2"));
    }

    static long answer;
    static ArrayList<Long> numList; // 숫자를 넣는 리스트
    static ArrayList<Character> opList; // 연산자를 순서대로 넣는 리스트
    static ArrayList<Character> opKind; // 연산자의 종류를 넣는 배열
    static boolean[] visited; //
    static char[] opOrder; // 연산 우선순위를 넣을 배열
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
            // 숫자면 stringbuilder append
            if ('0' <= tmp && tmp <= '9') {
                sb.append(tmp);
            } else {
                // 연산자인 경우 연산자 리스트에 추가
                // 이후 이전에 만든 sb를 숫자 리스트에 추가하고 초기화
                opList.add(tmp);
                numList.add(Long.parseLong(sb.toString()));
                set.add(tmp);
                sb = new StringBuilder();
            }
        }
        // 마지막 숫자는 따로 숫자 리스트에 추가해야함
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
            // 순열이 만들어지면 연산 시도
            Calc();
        } else {
            // 연산자의 우선순위를 부여해 순열을 만듦
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
        // 숫자 리스트를 복사
        ArrayList<Long> tmpNumList = new ArrayList<>(numList);
        // 연산자 리스트를 복사
        ArrayList<Character> tmpOpList = new ArrayList<>(opList);

        for (char c : opOrder) { // 연산자 우선순위대로 뽑아옴
            for (int i = 0; i < tmpOpList.size(); i++) {
                // 현재 연산자와 리스트의 연산자가 일치하면
                // 해당인덱스와 다음 인덱스의 숫자끼리 연산
                // 해당 인덱스에 연산 결과를 넣고 그다음 인덱스의 숫자는 삭제
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