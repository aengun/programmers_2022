package Level1.가운데_글자_가져오기;

class Solution {
    public String solution(String s) {
        String answer = "";

        int len = s.length();
        if (len % 2 == 1) {
            answer = s.substring(len / 2, len / 2 + 1);
        } else {
            answer = s.substring(len / 2 - 1, len / 2 + 1);
        }

        return answer;
    }
}

// class Solution {
//     public String solution(String s) {
//         String answer = "";
//         String[] alphabet = s.split("");

// 		if (s.length() % 2 != 0) {
// 			answer = alphabet[s.length() / 2];
// 		} else {
// 			answer += alphabet[s.length() / 2 - 1];
// 			answer += alphabet[s.length() / 2];
// 		}
//         return answer;
//     }
// }