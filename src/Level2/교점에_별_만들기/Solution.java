package Level2.교점에_별_만들기;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
        };
        int[][] arr2 = new int[][]{
                {0, 1, -1}, {1, 0, -1}, {1, 0, 1}
        };
//        new Solution().solution(arr);
        new Solution().solution(arr2);
    }

    static int[] combi = new int[2];
    static boolean[] visited;
    static int[][] lines;
    static long minX = Integer.MAX_VALUE;
    static long minY = Integer.MAX_VALUE;
    static long maxX = Integer.MIN_VALUE;
    static long maxY = Integer.MIN_VALUE;
    static HashSet<Point> set = new HashSet<>();

    public String[] solution(int[][] line) {
        String[] answer = {};

        visited = new boolean[line.length];
        lines = line; // line을 static으로 만들기 위함

        DFS(0, 0); // 두 직선의 조합 만들기

        if (minX == maxX && minY == maxY) return new String[]{"*"};
        long row = maxX - minX + 1;
        long col = maxY - minY + 1;

        answer = new String[(int) col];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < row; i++) {
            sb.append('.');
        }

        Arrays.fill(answer, sb.toString());

        long nx, ny;
        for (Point p : set) {
            ny = maxY - p.y;
            nx = p.x - minX;
            answer[(int) ny] = answer[(int) ny].substring(0, (int) nx) + "*"
                    + answer[(int) ny].substring((int) nx + 1);
        }

        return answer;
    }

    public static void DFS(int L, int start) {

        if (L == 2) {

            long a = lines[combi[0]][0];
            long b = lines[combi[0]][1];
            long e = lines[combi[0]][2];
            long c = lines[combi[1]][0];
            long d = lines[combi[1]][1];
            long f = lines[combi[1]][2];

            if (a * b - b * c != 0) {
                if ((b * f - e * d) % (a * d - b * c) != 0) return;
                if ((e * c - a * f) % (a * d - b * c) != 0) return;
                long x = (b * f - e * d) / (a * d - b * c);
                long y = (e * c - a * f) / (a * d - b * c);
                set.add(new Point(x, y));

                minX = Math.min(x, minX);
                minY = Math.min(y, minY);
                maxX = Math.max(x, maxX);
                maxY = Math.max(y, maxY);

            }

        } else {

            for (int i = start; i < visited.length; i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }

        }

    }

}

class Point {
    long x;
    long y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}