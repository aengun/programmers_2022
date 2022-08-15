package Level2.프렌즈4블록;

import java.util.*;

class Solution_못풂 {

    public static void main(String[] args) {
        System.out.println(new Solution_못풂().solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(new Solution_못풂().solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }

    static int answer;
    static char[][] map;

    public int solution(int m, int n, String[] board) {
        answer = 0;

        map = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {

                if (map[i][j] != 'O') {
                    check(i, j, m, n);
                }

            }
        }

        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

        return answer;
    }

    public static void check(int x, int y, int m, int n) {

        char tmp = map[x][y];
        if (x == m - 1 || y == n - 1) return;

        if (tmp == map[x + 1][y] && tmp == map[x][y + 1] && tmp == map[x + 1][y + 1]) {
            map[x][y] = 'O';
            map[x + 1][y] = 'O';
            map[x][y + 1] = 'O';
            map[x + 1][y + 1] = 'O';
            removeBlock(x, y);
        }

    }

    public static void removeBlock(int x, int y) {
        int indexX = x;
        // y열에 있는 블록을 밑으로 내림
        while (true) {
            if (indexX == 0) break;
            map[indexX + 1][y] = map[indexX - 1][y];
            map[indexX - 1][y] = 'O';
            indexX--;
        }

        int indexX2 = x;
        // y+1열에 있는 블록을 밑으로 내림
        while (true) {
            if (indexX2 == 0) break;
            map[indexX2 + 1][y + 1] = map[indexX2 - 1][y + 1];
            map[indexX2 - 1][y + 1] = 'O';
            indexX2--;
        }

        answer += 4;

    }

}