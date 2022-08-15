package Level2.삼각달팽이;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(1));
        System.out.println(new Solution().solution(5));
        System.out.println(new Solution().solution(6));
    }

    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2];

        int[][] map = new int[n][];
        for (int i = 1; i <= n; i++) {
            map[i - 1] = new int[i];
        }

        if(n == 1) return new int[]{1};

        int x = 0;
        int y = 0;
        int k = 1;
        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};
        int direction = 0; // 1: 아래, 2: 오른쪽, 3: 위
        while (true) {
            if (map[x][y] != 0) break;
            map[x][y] = k++;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (direction == 0) {
                if (nx == map.length || map[nx][ny] != 0) {
                    direction = 1;
                    y += 1;
                } else {
                    x = nx;
                    y = ny;
                }
                continue;
            } else if (direction == 1) {
                if (ny == map[x].length || map[nx][ny] != 0) {
                    direction = 2;
                    x -= 1;
                    y -= 1;
                } else {
                    x = nx;
                    y = ny;
                }
                continue;
            } else if (direction == 2) {
                if (map[nx][ny] != 0) {
                    direction = 0;
                    x += 1;
                } else {
                    x = nx;
                    y = ny;
                }
                continue;
            }

            break;

        }


        int index = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                answer[index++] = map[i][j];
            }
        }

        return answer;
    }
}