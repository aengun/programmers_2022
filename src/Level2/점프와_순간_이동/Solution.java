package Level2.점프와_순간_이동;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }
}


//10억이라 bfs 하면 안됨
// import java.util.*;

// public class Solution {

//     static boolean[] visited;
//     static int max = Integer.MIN_VALUE;

//     public int solution(int n) {
//         int ans = 0;

//         visited = new boolean[n+1];
//         BFS();

//         return ans;
//     }

//     public static void BFS(){

//         Queue<Position> q = new Queue<>();
//         q.add(new Position(0,0,0,0));

//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i = 0; i < size; i++){
//                 Position p = q.poll();
//                 int d = p.d;//현재 위치
//                 int m = p.m;//이전에 움직인 거리
//                 int u = p.u;//이전에 전지 사용한 량
//                 int s = p.s;//전지 사용량
//                 //한 칸씩 앞으로 가는 경우
//                 q.add(new Position(d+1, ))

//             }
//         }

//     }
// }

// class Position {
//     int d; //현재 위치
//     int m; //이전에 움직인 거리
//     int u; //이전에 전지를 사용한 양
//     int s; //전지 총 사용량
//     Position(int d, int m, int u, int s) {
//         this.d = d;
//         this.m = m;
//         this.u = u;
//         this.s = s;
//     }
// }