package Level2.다리를_지나는_트럭;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(new Solution().solution(100, 100, new int[]{10}));
        System.out.println(new Solution().solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Truck> waiting = new LinkedList<>(); // 대기중인 트럭
        LinkedList<Truck> bridge = new LinkedList<>(); // 다리 위에 있는 트럭
        for (int i : truck_weights) {
            waiting.offer(new Truck(i, 0));
        }

        int nowW = 0; // 현재 다리 위 트럭 무게의 합
        while (!waiting.isEmpty() || !bridge.isEmpty()) {
            while (true) {
                if (waiting.isEmpty()) {
                    // 대기중인 트럭이 없으면 break
                    break;
                } else {
                    Truck tmp = waiting.peek();
                    if (nowW + tmp.w <= weight) {
                        nowW += tmp.w;
                        bridge.offer(tmp);
                        waiting.poll();
                        break;
                    } else {
                        break;
                    }
                }
            }

            for (int i = 0; i < bridge.size(); i++) {
                Truck tmp = bridge.get(i);
                tmp.t++;
                if (tmp.t >= bridge_length) {
                    nowW -= tmp.w;
                    bridge.remove(i);
                    i--;
                }
            }

            answer++;

        }

        return answer + 1;
    }
}

class Truck {
    int w; //무게
    int t; //시간

    Truck(int w, int t) {
        this.w = w;
        this.t = t;
    }

    @Override
    public String toString() {
        return "{ w : " + w + ", t : " + t + " }";
    }
}