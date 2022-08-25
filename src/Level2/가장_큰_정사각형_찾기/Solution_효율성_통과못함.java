package Level2.가장_큰_정사각형_찾기;

class Solution_효율성_통과못함 {
    static int answer = 0;

    public int solution(int[][] board) {

        int row = board.length;

        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1) {
                    int maxSize = Math.min(row - i, col - j);
                    check(i, j, maxSize, board);
                }
            }
        }

        return answer;
    }

    static void check(int x, int y, int size, int[][] board) {

        // 한 변의 길이가 1부터 size인 것까지 체크한다.
        loop:
        for (int i = 1; i <= size; i++) {
            boolean flag = true;
            for (int j = x; j < x + i; j++) {
                for (int k = y; k < y + i; k++) {
                    if (board[j][k] != 1) {
                        flag = false;
                        break loop;
                    }
                }
            }
            if (flag) answer = Math.max(answer, i * i);
        }

    }
}