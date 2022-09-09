package Level2_다시풀기.교점에_별_만들기;

import java.util.*;

class Solution {

    static int minX = Integer.MAX_VALUE;
    static int minY = Integer.MAX_VALUE;
    static int maxX = Integer.MIN_VALUE;
    static int maxY = Integer.MIN_VALUE;
    static int[] combi = new int[2];
    static boolean[] visited;
    static HashSet<int[]> set = new HashSet<>();

    public String[] solution(int[][] line) {
        String[] answer = {};

        visited = new boolean[line.length];
        dfs(0, 0, line);
        for (int[] a : set) System.out.println(Arrays.toString(a));

        return answer;
    }

    private static void dfs(int L, int s, int[][] line) {
        if (L == 2) {

            int line1 = combi[0];
            int line2 = combi[1];
            int a = line[line1][0];
            int b = line[line1][1];
            int e = line[line1][2];
            int c = line[line2][0];
            int d = line[line2][1];
            int f = line[line2][2];

            //교점 구하기
            if (a * d != b * c) {
                int x = (a * f - e * d) / (a * d - b * c);
                int y = (e * c - a * f) / (a * d - b * c);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                set.add(new int[]{x, y});
            }

        } else {
            for (int i = s; i < line.length; i++) {
                combi[L] = i;
                dfs(L + 1, i + 1, line);
            }
        }
    }

}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}