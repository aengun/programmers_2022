package Level2.후보키;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

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

    static int numOfCol;
    static int[] combi;
    static int answer;
    static ArrayList<int[]> answerList = new ArrayList<>();

    public int solution(String[][] relation) {
        answer = 0;

        numOfCol = relation[0].length;
        combi = new int[numOfCol];

        for (int i = 1; i <= numOfCol; i++) {
            DFS(relation, i, 0, 0);
        }

        return answer;
    }

    static void DFS(String[][] relation, int n, int L, int s) {

        if (L == n) {
            //조합이 만들어지면 판단
            isPossible(relation, n, combi);
        } else {
            for (int i = s; i < numOfCol; i++) {
                combi[L] = i;
                DFS(relation, n, L + 1, i + 1);
            }
        }

    }

    private static void isPossible(String[][] relation, int n, int[] combi) {

        HashSet<String> set = new HashSet<>();
        // 해당 컬럼으로 문자열을 만들어 set에 넣는다
        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(relation[i][combi[j]]);
            }
            set.add(sb.toString());
        }
//        System.out.println(set);
        // set의 사이즈가 relation길이와 같으면 유일하게 식별할 수 있는 것,
        // 여기서 최소성을 만족하는 지 따져본다.

        if (set.size() == relation.length) {
            int[] answerArr = new int[n];
            for (int i = 0; i < n; i++) {
                answerArr[i] = combi[i];
            }

            boolean test = true;
            // test를 false로 만드는 조합이 없어야함
            // 이전에 나온 조합 중 하나라도 현재 answerArr에 포함관계인 것이 있으면 안됨
//            List<int[]> tmpList = Arrays.asList(answerArr);
            for (int[] tmp : answerList) {
                // answerList에 있는 후보키들을 꺼내 최소성을 만족하는 지 판단
                boolean flag = true;

                for (int i : tmp) {
                    if (!Arrays.stream(answerArr).anyMatch(j -> j == i)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    // flag == true면 최소성을 만족하지 못함
                    test = false;
                    break;
                }

            }

            if (test) {
                answer++;
                answerList.add(answerArr);
            }

        }

    }
}