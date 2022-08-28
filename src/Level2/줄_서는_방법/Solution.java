package Level2.줄_서는_방법;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(2,1)));
    }


    static long[] factorial = new long[21];

    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        factorial[0] = 1;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        // System.out.println(list);

        for(int i = 1; i <= 20; i++){
            factorial[i] = i * factorial[i-1];
        }

        // System.out.println(Arrays.toString(factorial));

        for(int i = 0; i < n; i++) {

            long f = factorial[n-i-1];
            System.out.println((int) ((long)k / f)+" / "+ f);
            answer[i] = list.get((int) ((long)k / f));
            list.remove((int)((long)k/f));
            k = k % f;
            // System.out.println(f);

        }

        return answer;
    }
}