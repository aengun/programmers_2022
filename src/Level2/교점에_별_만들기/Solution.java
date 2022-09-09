package Level2.교점에_별_만들기;

import java.util.*;

class Solution {

    static List<long[]> list = new ArrayList<>();
    static long minX = Long.MAX_VALUE;
    static long maxX = Long.MIN_VALUE;
    static long minY = Long.MAX_VALUE;
    static long maxY = Long.MIN_VALUE;
    static int[] combi = new int[2];
    static boolean[] visited;

    public String[] solution(int[][] line) {
        String[] answer = {};

        visited = new boolean[line.length];
        dfs(0, 0, line);

        boolean[][] answerMap = new boolean[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];

        for (long[] a : list) {
            int x = (int) (a[0] - minX);
            int y = (int) (a[1] - minY);
            // answerMap[Math.abs(y)][Math.abs(x)] = true;
            answerMap[(int) (maxY - minY - y)][x] = true;
        }

        answer = new String[answerMap.length];

        int i = 0;
        for (boolean[] b : answerMap) {
            StringBuilder sb = new StringBuilder();
            for (boolean f : b) {
                if (!f) sb.append('.');
                else sb.append('*');
            }
            answer[i] = sb.toString();
            i++;
        }

        return answer;
    }

    private static void dfs(int L, int s, int[][] line) {
        if (L == 2) {

            int line1 = combi[0];
            int line2 = combi[1];
            long a = line[line1][0];
            long b = line[line1][1];
            long e = line[line1][2];
            long c = line[line2][0];
            long d = line[line2][1];
            long f = line[line2][2];

            //교점 구하기
            if (a * d != b * c) {
                if ((b * f - e * d) % (a * d - b * c) != 0) return;
                if ((e * c - a * f) % (a * d - b * c) != 0) return;
                long x = (b * f - e * d) / (a * d - b * c);
                long y = (e * c - a * f) / (a * d - b * c);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                list.add(new long[]{x, y});
            }

        } else {
            for (int i = s; i < line.length; i++) {
                combi[L] = i;
                dfs(L + 1, i + 1, line);
            }
        }
    }

}