package Level2.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        for (int right = people.length - 1; right >= left; right--) {
            if (people[left] + people[right] <= limit) {
                left++;
                answer++;
            } else {
                answer++;
            }
        }

        return answer;
    }
}

// import java.util.Arrays;

// class Solution {
//     public int solution(int[] people, int limit) {
//         int answer = 0;
//         Arrays.sort(people);

// 		int i = 0;
// 		for (int k = people.length - 1; k >= i; k--) {
// 			if (people[i] + people[k] <= limit) {
// 				i++;
// 				answer++;
// 			} else {
// 				answer++;
// 			}
// 		}
//         return answer;
//     }
// }