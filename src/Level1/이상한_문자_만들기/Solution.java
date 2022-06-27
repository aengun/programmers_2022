package Level1.이상한_문자_만들기;

class Solution {
    public String solution(String s) {

        String answer = "";

        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                index = 0;
                sb.append(' ');
            } else {
                if (index % 2 == 0) sb.append(Character.toUpperCase(arr[i]));
                else sb.append(Character.toLowerCase(arr[i]));

                index++;
            }
        }

        answer = sb.toString();
        return answer;

    }
}
