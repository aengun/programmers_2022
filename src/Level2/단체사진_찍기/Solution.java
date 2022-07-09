package Level2.단체사진_찍기;

import java.util.*;

class Solution {

    static HashMap<Character, Integer> friends = new HashMap<>();
    static int answer;
    static String[] datas;
    static boolean[] visited;
    static int[] arr;

    public int solution(int n, String[] data) {
        answer = 0;
        datas = data;

        friends.put('A', 0);
        friends.put('C', 1);
        friends.put('F', 2);
        friends.put('J', 3);
        friends.put('M', 4);
        friends.put('N', 5);
        friends.put('R', 6);
        friends.put('T', 7);

        arr = new int[friends.size()];
        visited = new boolean[friends.size()];

        DFS(0);

        return answer;
    }

    static void DFS(int L) {

        if (L == 8) {

            boolean flag = true;

            for (String s : datas) {
                int index1 = arr[friends.get(s.charAt(0))];
                int index2 = arr[friends.get(s.charAt(2))];
                char operator = s.charAt(3);
                int distance = s.charAt(4) - '0' + 1;

                if (operator == '=') {
                    if (Math.abs(index1 - index2) != distance) flag = false;
                } else if (operator == '>') {
                    if (Math.abs(index1 - index2) <= distance) flag = false;
                } else {
                    if (Math.abs(index1 - index2) >= distance) flag = false;
                }
            }

            if (flag) {
                answer++;
            }

        } else {
            for (int i = 0; i < 8; i++) {
                if (visited[i] == false) {
                    visited[i] = true;
                    arr[L] = i;
                    DFS(L + 1);
                    visited[i] = false;
                }
            }
        }

    }
}