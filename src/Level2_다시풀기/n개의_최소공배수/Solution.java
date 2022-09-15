package Level2_다시풀기.n개의_최소공배수;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;

        int a = arr[0];
        int tmpGcd = 0;
        int tmpLcm = 0;
        for (int i = 1; i < arr.length; i++) {
            int b = arr[i];
            // System.out.println(a+" " + b + " " + tmpGcd + " " + tmpLcm);

            if (a < b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            tmpGcd = gcd(a, b);
            tmpLcm = lcm(a, b, tmpGcd);
            a = tmpLcm;
        }
        answer = tmpLcm;
        return answer;
    }

    // 반복문 방식
    static int gcd(int a, int b) {

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    static int lcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}