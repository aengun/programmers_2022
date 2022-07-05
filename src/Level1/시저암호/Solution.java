package Level1.시저암호;

class Solution {
    public String solution(String s, int n) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);

            if (tmp == ' ') {
                sb.append(' ');
                continue;
            }

            int num = tmp;
            int newNum = num + n;
            if (97 <= num && num <= 122) { //소문자
                if (newNum > 122) newNum -= 26;
            } else { //대문자
                if (newNum > 90) newNum -= 26;
            }
            sb.append((char) newNum);
        }

        answer = sb.toString();

        return answer;
    }
}

// class Solution {
//     public String solution(String s, int n) {
//         String answer = "";

//         for (int i = 0; i < s.length(); i++) {
// 			char c = s.charAt(i);
// 			if (65 <= c && c <= 90)
// 				c = (char) (((c - 65) + n) % 26 + 65);
// 			else if (97 <= c && c <= 122)
// 				c = (char) (((c - 97) + n) % 26 + 97);
// 			answer += c;
// 		}

//         return answer;
//     }
// }
