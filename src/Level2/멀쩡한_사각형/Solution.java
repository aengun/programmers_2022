package Level2.멀쩡한_사각형;

class Solution {
    public long solution(int w, int h) {
        long answer = 1;

        long lw = w;
        long lh = h;

        if (w < h) {
            int tmp = w;
            w = h;
            h = tmp;
        }

        int gdc = GDC(w, h);

        answer = (lw * lh) - ((lw / gdc) + (lh / gdc) - 1) * gdc;

        return answer;
    }

    static int GDC(int a, int b) {

        if (a % b == 0) {
            return b;
        } else {
            return GDC(b, a % b);
        }

    }
}
