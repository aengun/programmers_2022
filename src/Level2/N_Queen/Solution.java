package Level2.N_Queen;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(4));
    }

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
//            if (possible(3)){
//                 System.out.println(Arrays.toString(arr));
            answer++;
//            }
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
//        System.out.println(Arrays.toString(arr));
//        System.out.println(idx);
        for (int i = 0; i < idx; i++) {
//            System.out.println(Math.abs(idx - i) + " / " + Math.abs(arr[idx] - arr[i]));
            if (Math.abs(idx - i) == Math.abs(arr[idx] - arr[i])) {
//                System.out.println("---------------");
                return false;
            }
        }
//        System.out.println("=====================");
        return result;

    }

}