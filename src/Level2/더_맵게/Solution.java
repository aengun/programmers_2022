package Level2.더_맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        while (pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            pq.add(first + second * 2);
            answer++;

            if (pq.size() == 1 && pq.peek() < K) return -1;
        }

        return answer;
    }
}

// import java.util.PriorityQueue;
// class Solution {
//     public int solution(int[] scoville, int K) {
//         int answer = 0;
//         PriorityQueue<Integer> heap = new PriorityQueue<>();

// 		for (int i : scoville)
// 			heap.add(i);

// 		while (heap.peek() < K) {
//             if(heap.size()==1)
// 				return -1;
// 			int first = heap.poll();
// 			int second = heap.poll();

// 			int third = first + second * 2;
// 			heap.add(third);
// 			answer++;

// 		}
//         return answer;
//     }
// }