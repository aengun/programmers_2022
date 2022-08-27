package Level2.숫자_블록;

import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = {};

        answer = new int[(int) (end - begin) + 1];

        ArrayList<Integer> list = new ArrayList<>();

        for (long i = begin; i <= end; i++) {
            list.add((int) check(i));
        }

        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static long check(long n) {
        if (n == 1) return 0;
        else {
            // 약수 중 가장 큰 수를 찾아야한다.
            int result = 1;

            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    if (n / i > 10000000) {
                        continue;
                    }
                    return n / i;
                }
            }

            return result;
        }
    }

}