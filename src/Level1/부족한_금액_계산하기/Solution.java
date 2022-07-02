package Level1.부족한_금액_계산하기;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        long tmp = 0;
        for (int i = 1; i <= count; i++) {
            tmp += i;
        }

        long sum = tmp * price;
        if (sum > money) answer = sum - money;
        else return 0;

        return answer;
    }
}