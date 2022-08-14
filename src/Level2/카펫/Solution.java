package Level2.카펫;

import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        // yellow의 약수를 담은 리스트(세로의 길이만)
        ArrayList<Integer> list = new ArrayList<>();
        if (yellow == 1) return new int[]{3, 3};
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) list.add(i);
        }
        System.out.println(list);

        for (int i : list) {
            //i : yellow 가로 길이
            int j = yellow / i; // yellow 세로 길이
            if (i * 2 + j * 2 + 4 == brown) {
                answer = new int[]{j + 2, i + 2};
                break;
            }
        }

        return answer;
    }
}

// class Solution {
//     public int[] solution(int brown, int yellow) {
//         int[] answer = new int[2];

// 		int x = 0;
// 		int y = 0;

// 		for (y = 3; y <= brown + yellow; y++) {
// 			x = (brown + yellow) / y;
// 			if (yellow == (x - 2) * (y - 2)) {
// 				answer[0] = x;
// 				answer[1] = y;

// 				break;
// 			}
// 		}
//         return answer;
//     }
// }