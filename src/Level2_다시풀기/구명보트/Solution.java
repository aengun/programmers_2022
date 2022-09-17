package Level2_다시풀기.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Integer[] tmp = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder()); // 내림차순
        int left = 0;
        int right = people.length - 1;

        for (left = 0; left <= right; left++) {
            if (tmp[left] + tmp[right] <= limit) {
                right--;
            }
            // System.out.println(left + " " + right);
            answer++;
            // if(left>=right) answer++;
        }

        return answer;
    }
}
