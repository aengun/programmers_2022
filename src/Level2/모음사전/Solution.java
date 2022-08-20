package Level2.모음사전;

class Solution {
    public int solution(String word) {
        int answer = 0;

        int[] arr = { 781, 156, 31, 6, 1 };

        String str = "AEIOU";
        for (int i=0; i<word.length(); i++) {
            int idx = str.indexOf(word.charAt(i));
            answer += arr[i] * idx;
            System.out.println(answer);
        }

        answer += word.length();

        return answer;
    }
}