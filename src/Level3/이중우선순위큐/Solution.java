package Level3.이중우선순위큐;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> min = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        int cnt = 0;

        for (String s : operations) {
            String[] arr = s.split(" ");

            if (arr[0].equals("I")) {
                min.add(Integer.parseInt(arr[1]));
                max.add(Integer.parseInt(arr[1]));
                cnt++;
            } else {
                if (cnt == 0) continue;
                if (arr[1].equals("1")) {
                    //최댓값 삭제
                    int tmp = max.poll();
                    min.remove(tmp);
                    cnt--;
                } else {
                    int tmp = min.poll();
                    max.remove(tmp);
                    cnt--;
                }
            }

        }

        if (cnt == 0) {
            answer = new int[]{0, 0};
        } else {
            answer = new int[]{max.poll(), min.poll()};
        }

        return answer;
    }
}