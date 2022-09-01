package Level3.코딩_테스트_공부;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[][] p = new int[][]{{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}};
        int[][] p2 = new int[][]{
                {0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}
        };

//        System.out.println(new Solution().solution(10, 10, p));
        System.out.println(new Solution().solution(0, 0, p2));

    }

    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        int goalAl = 0;//목표 알고력
        int goalCo = 0;//목표 코딩력

        for (int i = 0; i < problems.length; i++) {
            goalAl = Math.max(goalAl, problems[i][0]);
            goalCo = Math.max(goalCo, problems[i][1]);
        }

        //이미 알고력, 코딩력이 충분한 경우
        if (goalAl <= alp && goalCo <= cop) {
            return answer;
        }

        if (alp >= goalAl) {
            alp = goalAl;
        }
        if (cop >= goalCo) {
            cop = goalCo;
        }

        int[][] dp = new int[goalAl + 2][goalCo + 2]; // i+1 연산때문에 +2로 사이즈 설정

        //dp 초기화 -> 최대값으로
        for (int i = 0; i <= goalAl; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[alp][cop] = 0;

        for (int i = alp; i <= goalAl; i++) {
            for (int j = cop; j <= goalCo; j++) {

                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] p : problems) {

                    if (p[0] > i || p[1] > j) continue;

                    if (i + p[2] > goalAl && j + p[3] > goalCo) {
                        // case1 : 둘다 충족한 경우
                        dp[goalAl][goalCo] = Math.min(dp[goalAl][goalCo], p[4] + dp[i][j]);
                    } else if (i + p[2] > goalAl) {
                        // case2 : alp는 이미 넘은 경우
                        dp[goalAl][j + p[3]] = Math.min(dp[goalAl][j + p[3]], p[4] + dp[i][j]);
                    } else if (j + p[3] > goalCo) {
                        // case3 : cop가 이미 넘은 경우
                        dp[i + p[2]][goalCo] = Math.min(dp[i + p[2]][goalCo], p[4] + dp[i][j]);
                    } else if (i + p[2] <= goalAl && j + p[3] <= goalCo) {
                        // case4 : 둘 다 넘지 않는 경우
                        dp[i + p[2]][j + p[3]] = Math.min(dp[i + p[2]][j + p[3]], p[4] + dp[i][j]);
                    }

                }

            }
        }

        answer = dp[goalAl][goalCo];

        return answer;
    }

//    public int solution(int alp, int cop, int[][] problems) {
//
//        int goal_a=0;
//        int goal_c=0;
//        //목표치를 구하는 for문
//        for(int i =0; i<problems.length;i++){
//            goal_a=Math.max(problems[i][0],goal_a);
//            goal_c=Math.max(problems[i][1],goal_c);
//        }
//
//        if(goal_a<=alp&&goal_c<=cop){
//            return 0;
//        }
//
//        if(alp>=goal_a){
//            alp=goal_a;
//        }
//        if(cop>=goal_c){
//            cop=goal_c;
//        }
//
//        int[][] dp =new int[goal_a+2][goal_c+2];
//
//        for(int i=alp;i<=goal_a;i++){
//            for(int j=cop;j<=goal_c;j++){
//                dp[i][j]=Integer.MAX_VALUE;
//            }
//        }
//
//        dp[alp][cop]=0;
//
//        for(int i=alp;i<=goal_a;i++){
//            for(int j=cop;j<=goal_c;j++){
//
//                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+1);
//
//                dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+1);
//
//                for(int[] p :problems){
//
//                    if(i>=p[0]&&j>=p[1]){
//                        if(i+p[2]>goal_a&&j+p[3]>goal_c){
//                            dp[goal_a][goal_c]=Math.min(dp[goal_a][goal_c],dp[i][j]+p[4]);
//                        }
//                        else if(i+p[2]>goal_a){
//                            dp[goal_a][j+p[3]]=Math.min(dp[goal_a][j+p[3]],dp[i][j]+p[4]);
//                        }
//                        else if(j+p[3]>goal_c){
//                            dp[i+p[2]][goal_c]=Math.min(dp[i+p[2]][goal_c],dp[i][j]+p[4]);
//                        }
//                        else if(i+p[2]<=goal_a&&j+p[3]<=goal_c){
//                            dp[i+p[2]][j+p[3]]=Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]);
//                        }
//                    }
//
//                }
//            }
//        }
//
//        for (int[] i : dp) {
//            System.out.println(Arrays.toString(i));
//        }
//        return dp[goal_a][goal_c];
//    }


}