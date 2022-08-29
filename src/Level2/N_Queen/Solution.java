package Level2.N_Queen;

import java.util.*;

class Solution {

    static int[] combi;
    static boolean[] check;
    static int depth;
    static int count = 0;

    public int solution(int n) {
        int answer = 0;

        combi = new int[n];
        check = new boolean[n];
        depth = n;

        combination(0);
        // System.out.println(count);
        answer = count;
        return answer;
    }

    public static void combination(int L) {

        if (L == depth) {
            if (possible(L - 1)) count++;
        } else {
            for (int i = 0; i < depth; i++) {
                if (!check[i]) {
                    check[i] = true;
                    if (possible(L - 1)) {
                        combi[L] = i;
                        combination(L + 1);
                    }
                    check[i] = false;
                }
            }
        }

    }

    public static boolean possible(int n) {

        for (int i = 0; i < n; i++) {
            if (Math.abs(n - i) == Math.abs(combi[n] - combi[i])) {
                // System.out.println(Arrays.toString(combi) + " // " + n + " / " + i);
                return false;
            }
        }

        return true;

    }

}