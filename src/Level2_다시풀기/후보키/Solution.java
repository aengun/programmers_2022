package Level2_다시풀기.후보키;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        String[][] arr = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}
        };
        System.out.println(new Solution().solution(arr));
    }

    static int[] keys;
    static int depth;
    static int answer;
    static String[][] relations;
    static ArrayList<ArrayList<Integer>> answerList = new ArrayList<>();

    public int solution(String[][] relation) {
        answer = 0;
        relations = relation;
        depth = relation[0].length;
        keys = new int[depth];
        for (int i = 1; i <= depth; i++) {
            permu(i, 0, 0);
        }

        return answer;
    }

    static void permu(int n, int L, int start) {

        if (L == n) {
            System.out.println(Arrays.toString(keys));
            isPossible(n);
        } else {
            for (int i = start; i < depth; i++) {
                keys[L] = i;
                permu(n, L + 1, i + 1);
            }
        }

    }

    static void isPossible(int n) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < relations.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(relations[i][keys[j]]);
            }
            set.add(sb.toString());
        }

        //1. set의 개수가 relation의 개수와 동일해야함
        if (set.size() != relations.length) {
            return;
        }

        ArrayList<Integer> current = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            current.add(keys[i]);
        }
        //2. 이전에 짜여진 조합으로 후보키가 되지 않아야 함
        boolean isOk = true;
        for (ArrayList<Integer> tmp : answerList) {
            boolean flag = false;
            for (int i : tmp) {
                if (current.contains(i)) {
                    flag = true;
                }
            }
            if (flag) {
                isOk = false;
                break;
            }
        }

        if (isOk) {
            answer++;
            answerList.add(current);
        }

    }
}