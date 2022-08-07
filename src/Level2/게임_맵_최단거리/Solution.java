package Level2.게임_맵_최단거리;

import java.util.*;

class Solution {

    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        int answer = 0;

        visited = new boolean[maps.length][maps[0].length];

        visited[0][0] = true;
        answer = BFS(maps);

        return answer;
    }

    static int BFS(int[][] maps) {
        // 도착점이 막혀있는 경우 -1 바로 리턴
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        // n!=0 , m!=0인 이유 : 테스트 19 반례 ) [[1,1,0,1]] 이런 경우 인덱스 오류남
        if (n != 0 && m != 0 && maps[n][m - 1] == 0 && maps[n - 1][m] == 0 && maps[n - 1][m - 1] == 0)
            return -1;

        Queue<Coordinate> q = new LinkedList<>();
        Coordinate start = new Coordinate(0, 0, 1);
        q.offer(start);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Coordinate tmp = q.poll();

                if (tmp.x == n && tmp.y == m) return tmp.moves;

                for (int j = 0; j < 4; j++) {
                    int nx = tmp.x + dx[j];
                    int ny = tmp.y + dy[j];
                    int nMoves = tmp.moves + 1;

                    if (nx >= 0 && nx <= n && ny >= 0 && ny <= m && maps[nx][ny] == 1 && visited[nx][ny] == false) {
                        visited[nx][ny] = true;
                        q.offer(new Coordinate(nx, ny, nMoves));
                    }
                }

            }

        }

        return -1;

    }

}

class Coordinate {
    int x;
    int y;
    int moves; // 현재까지 몇 번 움직였는지 담는 변수

    Coordinate(int x, int y, int moves) {
        this.x = x;
        this.y = y;
        this.moves = moves;
    }
}