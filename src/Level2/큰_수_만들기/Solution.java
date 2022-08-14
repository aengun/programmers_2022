package Level2.큰_수_만들기;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("1924", 2));
        System.out.println(new Solution().solution("1231234", 3));
        System.out.println(new Solution().solution("4177252841", 4));
    }

    public String solution(String number, int k) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        int index = 0;
        int max = 0;

        for (int i = 0; i < number.length() - k; i++) {
            max = 0;

            for (int j = index; j <= i + k; j++) {
                int tmp = number.charAt(j) - '0';
                if (tmp > max) {
                    max = tmp;
                    index = j+1;
                }
            }
            sb.append(max);
        }

        answer = sb.toString();

        return answer;
    }
}


// class Solution {
//     public String solution(String number, int k) {
//         String answer = "";
//         StringBuilder sb = new StringBuilder();

// 		int index = 0;

// 		for (int i = 0; i < number.length() - k; i++) {
// 			char max = '0';

// 			for (int j = index; j <= i + k; j++) {
// 				if (max < number.charAt(j)) {
// 					max = number.charAt(j);
// 					index = j + 1;
// 				}
// 			}
// 			sb.append(max);
// 		}
// 		answer = sb.toString();
//         return answer;
//     }
// }