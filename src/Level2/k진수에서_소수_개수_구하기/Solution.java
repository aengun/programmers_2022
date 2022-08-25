package Level2.k진수에서_소수_개수_구하기;

import java.util.*;

class Solution {

    static ArrayList<Long> list = new ArrayList<>();

    public int solution(int n, int k) {
        int answer = -1;

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }

        for (String s : sb.reverse().toString().split("0")) {
            if ("".equals(s)) continue; // 테스트2를 보면 공백인 경우가 발생함
            else if ("1".equals(s)) continue;
            else {
                isPrime(s);
            }
        }

        answer = list.size();

        return answer;
    }

    public static void isPrime(String s) {

        long n = Long.parseLong(s);

        if (n == 2) {
            list.add((long) 2);
            return;
        }

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return;
        }

        list.add(n);

    }
}