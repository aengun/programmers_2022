package Level2.배달;

import java.util.*;

class Solution {

    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    static boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        graph = new ArrayList<ArrayList<Edge>>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Edge>());
        }
        dis = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];
            graph.get(a).add(new Edge(b, cost));
            graph.get(b).add(new Edge(a, cost));
        }

        Dikstra(1);
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] <= K) answer++;
        }

        return answer;
    }

    public static void Dikstra(int v) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));
        dis[v] = 0;

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;

            if (nowCost > dis[now]) continue;

            for (Edge o : graph.get(now)) {
                if (dis[o.vex] > nowCost + o.cost) {
                    dis[o.vex] = nowCost + o.cost;
                    pq.offer(new Edge(o.vex, nowCost + o.cost));
                }
            }

        }

    }
}

class Edge implements Comparable<Edge> {
    int vex; //vertex : 정점
    int cost; //비용

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}