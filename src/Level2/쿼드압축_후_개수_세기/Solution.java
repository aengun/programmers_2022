package Level2.쿼드압축_후_개수_세기;

class Solution {

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};

        System.out.println(new Solution().solution(arr));
    }

    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {

        dp(0, 0, arr.length, arr);

        return answer;
    }

    public static void dp(int x, int y, int size, int[][] arr) {

        if (check(x, y, size, arr)) {
            answer[arr[x][y]]++;
            return;
        }

        dp(x, y, size / 2, arr);
        dp(x + size / 2, y, size / 2, arr);
        dp(x, y + size / 2, size / 2, arr);
        dp(x + size / 2, y + size / 2, size / 2, arr);

    }

    public static boolean check(int x, int y, int size, int[][] arr) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) return false;
            }
        }

        return true;

    }

}