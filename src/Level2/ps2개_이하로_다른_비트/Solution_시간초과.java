package Level2.ps2개_이하로_다른_비트;

import java.util.Arrays;

public class Solution_시간초과 {

    public static void main(String[] args) {

        System.out.println(new Solution_시간초과().solution(new long[]{2, 7}));

    }

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            long num = numbers[i];
            String bin = Long.toBinaryString(num);

            long num2 = num;

            while (true) {

                num2 += 1; //1씩 큰 수를 만들어 테스트
                int diff = 0; //차이가 몇개인지 확인하는 변수
                String bin2 = Long.toBinaryString(num2);
                int leng = bin.length() - 1;
                int leng2 = bin2.length() - 1;

                while (leng2 >= 0) {

                    if (leng == -1) {
                        if (bin2.charAt(leng2) == '1')
                            diff++;
                        leng2--;

                    } else {
                        if (bin.charAt(leng) != bin2.charAt(leng2)) {
                            diff++;
                        }
                        leng--;
                        leng2--;
                    }

                    if (leng2 == -1) {
                        if (diff <= 2) answer[i] = num2;
                        break;
                    }

                }

                if (answer[i] != 0) break;

            }

        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
