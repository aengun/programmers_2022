package Level3.섬_연결하기;

import java.util.*;

class Solution {

    static int unf[];

    public int solution(int n, int[][] costs) {
        int answer = 0;

        unf = new int[n];
        for (int i = 0; i < n; i++) {
            unf[i] = i;
        }
        ArrayList<Edge> list = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];
            list.add(new Edge(a, b, c));
        }
        Collections.sort(list);
        // System.out.println(list);

        for (Edge ob : list) {
            int fv1 = Find(ob.v1);
            int fv2 = Find(ob.v2);
            if (fv1 != fv2) {
                answer += ob.cost;
                Union(fv1, fv2);
            }
        }
        // System.out.println(Arrays.toString(unf));

        return answer;
    }

    public static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

}

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int cost;

    Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }

    @Override
    public String toString() {
        return "{ v1 : " + v1 + ", v2 : " + v2 + ", cost : " + cost + " }";
    }
}