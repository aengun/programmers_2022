package Level2.숫자의_표현;

class Solution {
    public int solution(int n) {
        int answer = 0;

        int left = 1;
        int right = 2;
        int sum = 3;

        if (n == 1) return 1;
        else if (n == 2) return 1;
        else if (n == 3) return 2;

        while (left <= right) {

            if (sum < n) {
                right++;
                sum += right;
            } else {
                sum -= left;
                left++;
            }

            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }
}

// class Solution {
//     public int solution(int n) {
//         int answer = 0;
//         int sum = 0;
// 		int start = 0;
// 		int end = 0;
// 		int[] arr = new int[n];

// 		for (int i = 0; i < n; i++) {
// 			arr[i] = i + 1;
// 		}

// 		while (start < n) {
// 			if (sum > n || end == n) {
// 				sum -= arr[start];
// 				start++;
// //				System.out.println("start : " + start);
// 			} else if (sum < n) {
// 				sum += arr[end];
// 				if (end < n-1)
// 					end++;
// 			}

// 			if (sum == n) {
// 				answer++;
// 				sum -= arr[start];
// 				start++;
// 				sum += arr[end];
// 				end++;
// 			}

// 		}
//         return answer;
//     }
// }
