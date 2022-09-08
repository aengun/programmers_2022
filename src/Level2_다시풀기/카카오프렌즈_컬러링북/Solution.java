package Level2_다시풀기.카카오프렌즈_컬러링북;

class Solution {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
        };
        System.out.println(new Solution().solution(6, 4, arr));
        int[][] arr2 = {{0, 1, 0}};
        System.out.println(new Solution().solution(1, 3, arr2));
    }

    static int numberOfArea = 0;
    static int maxSizeOfOneArea = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int tmpCnt;
    static int M;
    static int N;

    public int[] solution(int m, int n, int[][] picture) {

        M = m;
        N = n;



        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0) {
                    int color = picture[i][j];
                    picture[i][j] = 0;
                    numberOfArea++;
                    tmpCnt = 1;
                    DFS(i, j, color, picture);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmpCnt);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(numberOfArea);
        System.out.println(maxSizeOfOneArea);
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