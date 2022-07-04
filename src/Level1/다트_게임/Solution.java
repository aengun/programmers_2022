package Level1.다트_게임;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T"));
    }

    public static int solution(String dartResult) {
        int answer = 0;

        int index = 0;
        int[] arr = new int[3];

        for (int i = 0; i < dartResult.length(); i++) {
            char tmp = dartResult.charAt(i);

            if (tmp == 'S') continue;
            else if (tmp == 'D') {
                arr[index] = (int) Math.pow(arr[index], 2);
            } else if (tmp == 'T') {
                arr[index] = (int) Math.pow(arr[index], 3);
            } else if (tmp == '*') {
                if (index == 0) arr[index] *= 2;
                else {
                    System.out.println("beofre : " + Arrays.toString(arr));
                    arr[index] *= 2;
                    System.out.println(arr[index - 1]);
                    arr[index - 1] = arr[index - 1] * 2;
                    System.out.println("after. : " + Arrays.toString(arr));
                }
            } else if (tmp == '#') {
                arr[index] *= (-1);
            } else {
                if (tmp == '1' && dartResult.charAt(i + 1) == '0') {
                    arr[index] = 10;
                    i++;
                } else {
                    arr[index] = tmp - '0';
                }
                if (index != 2)
                    index++;
            }

        }
        System.out.println(Arrays.toString(arr));
        for (int i : arr) answer += i;

        return answer;
    }
}