package Level2.소수_찾기;

import java.util.*;

class Solution {

    static int answer;
    static int max;
    static char[] arr;
    static boolean[] ch;
    static boolean[] visited;

    public int solution(String numbers) {
        answer = 0;

        arr = numbers.toCharArray();
        visited = new boolean[arr.length];
        Character[] arr2 = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr2[i];
        }

        max = Integer.parseInt(new String(arr));
        ch = new boolean[max + 1];
        ch[0] = true;
        ch[1] = true;
        // 에라토스테네스의 체
        for (int i = 2; i < max; i++) {
            for (int j = i * 2; j <= max; j += i) {
                if (!ch[j]) {
                    ch[j] = true;
                }
            }
        }

        for (int i = 1; i <= Integer.toString(max).length(); i++) {
            char[] tmp = new char[i];
            DFS(i, 0, tmp);
        }

        return answer;
    }

    public static void DFS(int i, int L, char[] tmp) {

        if (L == i) {
            int num = Integer.parseInt(new String(tmp));
            if (ch[num] == false) {
                ch[num] = true;
                answer++;
            }
        } else {
            for (int j = 0; j < arr.length; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    tmp[L] = arr[j];
                    DFS(i, L + 1, tmp);
                    visited[j] = false;
                }
            }
        }

    }
}