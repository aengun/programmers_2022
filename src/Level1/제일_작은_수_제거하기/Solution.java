package Level1.제일_작은_수_제거하기;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};

        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        if (arr.length == 1) return new int[]{-1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }

        answer = new int[arr.length - 1];

        int answerIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == minIndex) continue;
            else {
                answer[answerIndex] = arr[i];
                answerIndex++;
            }
        }

        return answer;
    }
}

