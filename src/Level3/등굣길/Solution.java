package Level3.등굣길;

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;

        int[][] map = new int[n + 1][m + 1];

        for (int i = 0; i < puddles.length; i++) {
            int[] tmp = puddles[i];
            map[tmp[1]][tmp[0]] = -1;
        }
        // 1열의 값을 1로 세팅
        for (int i = 1; i <= n; i++) {
            //웅덩이가 나오면 나머지 값은 0으로 남겨둬야 하므로 break
            if (map[i][1] == -1) break;
            map[i][1] = 1;
        }
        // 1행의 값을 1로 세팅
        for (int i = 1; i <= m; i++) {
            //웅덩이가 나오면 나머지 값은 0으로 남겨둬야 하므로 break
            if (map[1][i] == -1) break;
            map[1][i] = 1;
        }

//         for(int i = 0; i <= n; i++){
//             System.out.println(Arrays.toString(map[i]));
//         }

//         System.out.println("------------");

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                if (map[i][j] != -1) {
                    if (map[i - 1][j] == -1 && map[i][j - 1] == -1) {
                        // 왼쪽과 위쪽이 물에 잠긴 지역인 경우 0
                        map[i][j] = 0;
                    } else if (map[i - 1][j] == -1) {
                        // 위만 물에 잠긴 경우
                        map[i][j] = map[i][j - 1] % 1000000007;
                    } else if (map[i][j - 1] == -1) {
                        // 왼쪽만 물에 잠긴 경우
                        map[i][j] = map[i - 1][j] % 1000000007;
                    } else {
                        map[i][j] = (map[i - 1][j] + map[i][j - 1]) % 1000000007;
                    }
                }
            }
        }

        // for(int i = 0; i <= n; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }

        answer = map[n][m];

        return answer;
    }
}