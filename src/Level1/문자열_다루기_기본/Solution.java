package Level1.문자열_다루기_기본;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        if (s.length() == 4 || s.length() == 6) {
            for (char c : s.toCharArray())
                if (c < '0' || c > '9') return false;

        } else {
            answer = false;
        }

        return answer;
    }
}

// class Solution {
//     public boolean solution(String s) {
//         boolean answer = true;
// char[] chars = s.toCharArray();

// 		if (chars.length != 4 && chars.length != 6)
// 			return false;

// 		for (char c : chars)
// 			if (c < 48 || 57 < c)
// 				return false;
//         return answer;
//     }
// }