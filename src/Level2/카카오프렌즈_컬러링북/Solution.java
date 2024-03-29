package Level2.카카오프렌즈_컬러링북;

class Solution {

    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int tmpCnt;
    static int M;
    static int N;
    static int[][] pictures;

    public int[] solution(int m, int n, int[][] picture) {

        pictures = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pictures[i][j] = picture[i][j];
            }
        }

        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        M = m;
        N = n;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pictures[i][j] != 0) {
                    int color = pictures[i][j];
                    pictures[i][j] = 0;
                    numberOfArea++;
                    tmpCnt = 1;
                    DFS(i, j, color, pictures);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmpCnt);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;

    }

    private static void DFS(int x, int y, int color, int[][] picture) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < M && 0 <= ny && ny < N && picture[nx][ny] == color) {
                picture[nx][ny] = 0;
                tmpCnt++;
                DFS(nx, ny, color, picture);
            }
        }

    }

}