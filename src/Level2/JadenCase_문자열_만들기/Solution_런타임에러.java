package Level2.JadenCase_문자열_만들기;

class Solution_런타임에러 {
    public String solution(String s) {
        String answer = "";

        s = s.toLowerCase();

        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String tmp = arr[i];
            arr[i] = Character.toString(tmp.charAt(0)).toUpperCase() + tmp.substring(1);
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                answer += arr[i] + " ";
            } else answer += arr[i];
        }

        if (s.charAt(s.length() - 1) == ' ') answer += " ";

        return answer;
    }
}

// class Solution {
//     public String solution(String s) {
//         String answer = "";
//         s = s.toLowerCase();

// 		String arr[] = s.split(" ");

// 		for (int i = 0; i < arr.length; i++) {
// 			if(arr[i].length()>=1) {
// 				String a = "" + arr[i].toUpperCase().charAt(0);
// 				arr[i] = a + arr[i].substring(1);
// 			}
// 		}

// 		for (int i = 0; i < arr.length; i++) {
// 			if(i == arr.length-1) {
// 				answer += arr[i];
// 			} else {
// 				answer += arr[i] + " ";
// 			}
// 		}

// 		if(s.charAt(s.length()-1) == ' ') {
// 			answer = answer+" ";
// 		}
//         return answer;
//     }
// }