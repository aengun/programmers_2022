package Level1.다트_게임;

class Solution {

    public static int solution(String dartResult) {
        int answer = 0;

        int index = 0;
        int[] arr = new int[3];

        for (int i = 0; i < dartResult.length(); i++) {
            char tmp = dartResult.charAt(i);

            if (tmp == 'S') continue;
            else if (tmp == 'D') {
                arr[index - 1] = (int) Math.pow(arr[index - 1], 2);
            } else if (tmp == 'T') {
                arr[index - 1] = (int) Math.pow(arr[index - 1], 3);
            } else if (tmp == '*') {
                if (index == 1) arr[index - 1] *= 2;
                else {
                    arr[index - 1] *= 2;
                    arr[index - 2] *= 2;
                }
            } else if (tmp == '#') {
                arr[index - 1] *= (-1);
            } else {
                if (tmp == '1' && dartResult.charAt(i + 1) == '0') {
                    arr[index] = 10;
                    i++;
                } else {
                    arr[index] = tmp - '0';
                }
                index++;
            }

        }

        for (int i : arr) answer += i;

        return answer;
    }
}