package Level2.ps124_나라의_숫자;

class Solution {
    public String solution(int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            int tmp = n % 3;
            if (tmp != 0) {
                sb.append(tmp);
                n = n / 3;
            } else {
                sb.append(4);
                n = n / 3 - 1;
            }
        }

        answer = sb.reverse().toString();

        return answer;
    }
}

// class Solution {
//     public String solution(int n) {
//         String answer = "";
//         StringBuilder sb = new StringBuilder();
// 		while (n > 0) {
// 			int rest = n % 3;
// 			if (rest == 0) {
// 				rest = 4;
// 				n--;
// 			}
// 			sb.append(rest);
// 			n /= 3;
// 		}

// 		answer = sb.reverse().toString();
//         return answer;
//     }
// }
