package Level1.문자열_내_p와_y의_개수;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int p = 0, y = 0;
        s = s.toLowerCase();
        System.out.println(s);

        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if (tmp == 'p') p++;
            else if (tmp == 'y') y++;
        }

        if (p != y) answer = false;

        return answer;
    }
}

// class Solution {
//     boolean solution(String s) {
//         boolean answer = true;

//         String[] strings = s.split("");

// 		int countP = 0, countY = 0;
// 		for (String st : strings)
// 			if (st.toLowerCase().equals("p"))
// 				countP++;
// 			else if (st.toLowerCase().equals("y"))
// 				countY++;

// 		if (countP == 0 && countY == 0)
// 			return true;
// 		else if (countP == countY)
// 			answer = true;
// 		else
// 			answer = false;
//         return answer;
//     }
// }