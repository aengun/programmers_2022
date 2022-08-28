package Level2.최댓값과_최솟값;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");
        int[] arr2 = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            arr2[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(arr2);

        answer = arr2[0] + " " + arr2[arr2.length - 1];

        return answer;
    }
}

// import java.util.Arrays;
// class Solution {
//     public String solution(String s) {
//         String answer = "";
//         String[] numsString = s.split(" ");

// 		int[] numsInt = new int[numsString.length];

// 		for (int i = 0; i < numsString.length; i++)
// 			numsInt[i] = Integer.parseInt(numsString[i]);

// 		Arrays.sort(numsInt);

// 		answer = numsInt[0]+" "+numsInt[numsInt.length-1];
//         return answer;
//     }
// }