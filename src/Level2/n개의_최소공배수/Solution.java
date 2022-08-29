package Level2.n개의_최소공배수;

import java.util.*;

class Solution {

    static int[] arr;
    static int m;
    static boolean[] check;
    static int answer;

    public int solution(int n) {
        answer = 0;
        m = n;
        arr = new int[n];
        check = new boolean[n];

        DFS(0);

        return answer;
    }

    public static void DFS(int L) {
        if (L == m) {
            if (possible(3))
                answer++;
            return;
        } else {
            for (int i = 0; i < m; i++) {
                if (check[i] == false) {
                    check[i] = true;
                    arr[i] = L;
                    if (possible(i)) DFS(L + 1);
                    check[i] = false;
                }
            }
        }
    }

    public static boolean possible(int idx) {
        boolean result = true;
        for (int i = 0; i < idx; i++) {
            if (Math.abs(idx - i) == Math.abs(arr[idx] - arr[i])) {
                return false;
            }
        }

        return result;

    }

}