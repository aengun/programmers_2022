package Level2.땅따먹기;

import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int n = land.length;

        int[][] map = new int[n][4];
        map[0][0] = land[0][0];
        map[0][1] = land[0][1];
        map[0][2] = land[0][2];
        map[0][3] = land[0][3];

        for (int i = 1; i < n; i++) {

            map[i][0] = Math.max(map[i - 1][1], Math.max(map[i - 1][2], map[i - 1][3])) + land[i][0];
            map[i][1] = Math.max(map[i - 1][0], Math.max(map[i - 1][2], map[i - 1][3])) + land[i][1];
            map[i][2] = Math.max(map[i - 1][0], Math.max(map[i - 1][1], map[i - 1][3])) + land[i][2];
            map[i][3] = Math.max(map[i - 1][0], Math.max(map[i - 1][1], map[i - 1][2])) + land[i][3];

        }

        for (int i = 0; i < map[0].length; i++) {
            answer = Math.max(answer, map[n - 1][i]);
        }

        return answer;
    }
}

// class Solution {
//     int solution(int[][] land) {
//         int answer = 0;

//         for (int i = 1; i < land.length; i++) {

// 			land[i][0] += Math.max(land[i - 1][1], Math.max(land[i - 1][2], land[i - 1][3]));
// 			land[i][1] += Math.max(land[i - 1][0], Math.max(land[i - 1][2], land[i - 1][3]));
// 			land[i][2] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][3]));
// 			land[i][3] += Math.max(land[i - 1][0], Math.max(land[i - 1][1], land[i - 1][2]));

// 		}

// 		for (int i = 0; i < land[0].length; i++)
// 			answer = (answer < land[land.length-1][i]) ? land[land.length-1][i] : answer;

//         return answer;
//     }
// }