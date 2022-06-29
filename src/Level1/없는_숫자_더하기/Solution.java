package Level1.없는_숫자_더하기;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        boolean[] check = new boolean[10];

        for (int i = 0; i < numbers.length; i++) {
            check[numbers[i]] = true;
        }

        for (int i = 0; i < check.length; i++) {
            if (!check[i]) answer += i;
        }

        return answer;
    }
}