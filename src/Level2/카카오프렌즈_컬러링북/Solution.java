package Level2.카카오프렌즈_컬러링북;

class Solution {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int size;
    static int[][] pictures;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        pictures = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pictures[i][j] = picture[i][j];
            }
        }

        int[] answer = new int[2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pictures[i][j] != 0) {
                    int color = pictures[i][j];
                    pictures[i][j] = 0;
                    numberOfArea++;
                    size = 1;
                    DFS(m, n, i, j, pictures, color);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static void DFS(int m, int n, int x, int y, int[][] picture, int color) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < m && 0 <= ny && ny < n && picture[nx][ny] == color) {
                picture[nx][ny] = 0;
                size++;
                DFS(m, n, nx, ny, picture, color);
            }
        }

    }

}