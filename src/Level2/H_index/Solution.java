package Level2.H_index;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        for (int i = 0; i < citations[citations.length - 1]; i++) {
            int lower = 0;
            int higher = 0;
            for (int j : citations) {
                if (i <= j) higher++;
                if (i >= j) lower++;
            }
            if (higher >= i && i >= lower) {
                answer = i;
            }
        }

        return answer;
    }
}

// import java.util.Arrays;
// class Solution {
//     public int solution(int[] citations) {
//         int answer = 0;
//        Arrays.sort(citations);

// 		for (int i = 0; i <= citations[citations.length - 1]; i++) {
// 			int count = 0;
// 			for (int j = 0; j < citations.length; j++) {
// 				if (citations[j] >= i)
// 					count++;
// 			}

// 			if (count >= i)
// 				answer = i;
// 			else
// 				break;

// 		}
//         return answer;
//     }
// }
