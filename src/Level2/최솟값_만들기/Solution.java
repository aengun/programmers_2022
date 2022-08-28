package Level2.최솟값_만들기;

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int n = A.length;
        for (int i = 0; i < n; i++) {
            answer += A[i] * B[n - 1 - i];
        }

        return answer;
    }
}

// import java.util.Arrays;
// class Solution
// {
//     public int solution(int []A, int []B)
//     {
//         int answer = 0;

//         Arrays.sort(A);
// 		Arrays.sort(B/* , Collections.reverseOrder() */); // 역순 정렬 하려면 wrapper class로 배열 만들어야함

// 		int n = A.length;
// 		for (int i = 0; i < n; i++) {
// 			answer += A[i] * B[n - 1 - i];
// 		}

//         return answer;
//     }
// }