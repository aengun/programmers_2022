package Level1.같은_숫자는_싫어;

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (list.size() == 0) list.add(i);
            else {
                if (list.get(list.size() - 1) == i) continue;
                else list.add(i);
            }
        }

        answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }
}

// import java.util.*;

// public class Solution {
//     public int[] solution(int []arr) {
//         int[] answer = {};

//         List<Integer> list = new ArrayList<>();

// 		int num = arr[0];
// 		list.add(num);
// 		for (int i = 0; i < arr.length; i++) {
// 			if (arr[i] == num)
// 				continue;
// 			else {
// 				num = arr[i];
// 				list.add(num);
// 			}
// 		}

// 		answer = new int[list.size()];

// 		for(int i =0;i<answer.length;i++)
// 			answer[i] = list.get(i);

//         return answer;
//     }
// }