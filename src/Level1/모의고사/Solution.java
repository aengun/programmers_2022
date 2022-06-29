package Level1.모의고사;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 1})));
    }

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] arr1 = new int[]{1, 2, 3, 4, 5}; // 5개
        int[] arr2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; // 8개
        int[] arr3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10개

        int tmp1 = 0, tmp2 = 0, tmp3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (arr1[i % 5] == answers[i]) {
                tmp1++;
            }

            if (arr2[i % 8] == answers[i]) {
                tmp2++;
            }

            if (arr3[i % 10] == answers[i]) {
                tmp3++;
            }
        }

        int max = Math.max(tmp1, Math.max(tmp2, tmp3));

        ArrayList<Integer> list = new ArrayList<>();

        if (tmp1 == max) list.add(1);
        if (tmp2 == max) list.add(2);
        if (tmp3 == max) list.add(3);

        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}

// import java.util.ArrayList;

// class Solution {
//     public int[] solution(int[] answers) {
//         int[] answer = {};

// 		int[] supo1 = { 1, 2, 3, 4, 5 };
// 		int[] supo2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
// 		int[] supo3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

// 		// 맞은 개수 확인
// 		int supo1r = supo(supo1, answers);
// 		int supo2r = supo(supo2, answers);
// 		int supo3r = supo(supo3, answers);

// 		int[] result = { supo1r, supo2r, supo3r };

// 		// 제일 많이 맞은 사람 찾기
// 		ArrayList<Integer> list = new ArrayList<>();
// 		int max = 0;
// 		for (int i = 0; i < result.length; i++) {
// 			if (max <= result[i]) {
// 				max = result[i];
// 			}
// 		}
// 		System.out.println(max);
// 		// 동점자 처리
// 		for (int i = 0; i < result.length; i++) {
// 			if (max == result[i]) {
// 				list.add(i + 1);
// 			}
// 		}

// 		// 배열에 담기
// 		answer = new int[list.size()];
// 		for (int i = 0; i < list.size(); i++) {
// 			answer[i] = list.get(i);
// 		}

// 		return answer;
// 	}

// 	private static int supo(int[] supo, int[] answers) {

// 		int result = 0;

// 		for (int i = 0; i < answers.length; i++) {
// 			if (answers[i] == supo[i % supo.length]) {
// 				result++;
// 			}
// 		}

// 		return result;

// 	}
// }