package Level1.폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int[] choice = new int[nums.length / 2];

        Arrays.sort(nums);
        int index = 1;
        choice[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && index < nums.length / 2) {
                choice[index] = nums[i];
                index++;
            }
        }

        for (int i = 0; i < choice.length; i++) {
            if (choice[i] != 0) answer++;
        }

        return answer;
    }
}
