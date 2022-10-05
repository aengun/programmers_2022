package Level3.가장_먼_노드;

import java.util.*;

class Solution {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] visited;
    static int depth = 0;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        visited = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int[] tmp : edge) {
            int start = tmp[0];
            int end = tmp[1];
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        // for(ArrayList<Integer> l : adj){
        //     System.out.println(l);
        // }
        Node start = new Node(1, 1);
        visited[1] = 1;
        bfs(start);
        // System.out.println(Arrays.toString(visited));

        for (int i : visited) {
            if (i == depth) answer++;
        }

        return answer;
    }

    static void bfs(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            Node tmp = q.poll();
            int start = tmp.p;
            int step = tmp.s;
            if (step > depth) depth = step;
            for (int i = 0; i < adj.get(start).size(); i++) {

                int next = adj.get(start).get(i);

                if (visited[next] != 0) continue;

                visited[next] = step + 1;
                Node nextNode = new Node(next, step + 1);
                q.add(nextNode);

            }
        }
    }
}

class Node {
    int p; //현재 위치
    int s; //몇 번 건너 왔는지 담는 변수

    Node(int p, int s) {
        this.p = p;
        this.s = s;
    }
}