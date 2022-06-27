package Level1.최대공약수와_최소공배수;

class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {};

        int gdc = GDC(n, m);

        answer = new int[]{gdc, n * m / gdc};

        return answer;
    }

    public static int GDC(int a, int b) {
        int r = 1;

        while (r > 0) {
            r = a % b;
            a = b;
            b = r;
        }

        return a;

    }

}