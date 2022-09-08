package Level2_다시풀기.최댓값과_최솟값;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] arr = s.split(" ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String str : arr) {
            int tmp = Integer.parseInt(str);

            if (max < tmp) max = tmp;
            if (min > tmp) min = tmp;
        }

        answer = min + " " + max;

        return answer;
    }
}