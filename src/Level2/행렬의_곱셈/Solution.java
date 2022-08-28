package Level2.행렬의_곱셈;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};

        int l = arr1.length;
        int m = arr1[0].length;
        int n = arr2[0].length;

        answer = new int[l][n];

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }

        return answer;
    }
}

// class Solution {
//     public int[][] solution(int[][] arr1, int[][] arr2) {
//         int[][] answer = {};
//         answer = new int[arr1.length][arr2[0].length];
// 		for (int i = 0; i < arr1.length; i++) {
// 			for (int j = 0; j < arr1[0].length; j++) {
// 				for (int k = 0; k < arr2[0].length; k++) {
// 					answer[i][k] += arr1[i][j]*arr2[j][k];
// 				}
// 			}
// 		}
//         return answer;
//     }
// }