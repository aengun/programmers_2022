package Level2.거리두기_확인하기;

class Solution {

    static int[] dx1 = {-1, 0, 1, 0};
    static int[] dy1 = {0, 1, 0, -1};
    static int[] dx2 = {-1, 1, 1, -1};
    static int[] dy2 = {1, 1, -1, -1};
    static int[] dx3 = {-2, 0, 2, 0};
    static int[] dy3 = {0, 2, 0, -2};
    static char[][] map;

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        map = new char[5][5];
        for (int i = 0; i < answer.length; i++) {

            String[] interview = places[i];

            for (int j = 0; j < 5; j++) {
                map[j] = interview[j].toCharArray();
            }

            int tmp = 1;

            tmp = DFS();

            answer[i] = tmp;

        }

        return answer;
    }

    static int DFS() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {
                    map[i][j] = 'O';
                    boolean flag = test(i, j);
                    if (flag) return 0;
                }
            }
        }

        return 1;

    }

    static boolean test(int x, int y) {

        boolean flag = false;

        //상하 좌우에 p가 있으면 바로 true
        for (int i = 0; i < 4; i++) {
            int nx = x + dx1[i];
            int ny = y + dy1[i];
            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && map[nx][ny] == 'P') return true;
        }

        //대각선 4방향에 p가 있는 경우 파티션이 없으면 true
        for (int i = 0; i < 4; i++) {
            int nx = x + dx2[i];
            int ny = y + dy2[i];
            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && map[nx][ny] == 'P') {
                int nx2;
                int ny2;
                int nx3;
                int ny3;
                switch (i) {
                    case 0:
                        nx2 = x + dx1[0];
                        ny2 = y + dy1[0];
                        nx3 = x + dx1[1];
                        ny3 = y + dy1[1];
                        if (map[nx2][ny2] != 'X' || map[nx3][ny3] != 'X') return true;
                        break;
                    case 1:
                        nx2 = x + dx1[1];
                        ny2 = y + dy1[1];
                        nx3 = x + dx1[2];
                        ny3 = y + dy1[2];
                        if (map[nx2][ny2] != 'X' || map[nx3][ny3] != 'X') return true;
                        break;
                    case 2:
                        nx2 = x + dx1[2];
                        ny2 = y + dy1[2];
                        nx3 = x + dx1[3];
                        ny3 = y + dy1[3];
                        if (map[nx2][ny2] != 'X' || map[nx3][ny3] != 'X') return true;
                        break;
                    case 3:
                        nx2 = x + dx1[3];
                        ny2 = y + dy1[3];
                        nx3 = x + dx1[0];
                        ny3 = y + dy1[0];
                        if (map[nx2][ny2] != 'X' || map[nx3][ny3] != 'X') return true;
                        break;
                    default:
                        break;
                }
            }

        }

        // 직선상 거리가 2인 자리에 사람이 있을 때
        // 사이에 파티션이 없으면 true
        for (int i = 0; i < 4; i++) {
            int nx = x + dx3[i];
            int ny = y + dy3[i];
            if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && map[nx][ny] == 'P') {
                int nx2 = x + dx1[i];
                int ny2 = y + dy1[i];
                if (map[nx2][ny2] != 'X') return true;
            }
        }

        return flag;

    }

}