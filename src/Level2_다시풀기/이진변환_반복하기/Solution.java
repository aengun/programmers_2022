package Level2_다시풀기.이진변환_반복하기;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};

        int cntZero = 0;
        int cntConv = 0;
        StringBuilder sb = new StringBuilder();

        while (!s.equals("1")) {
            sb = new StringBuilder();
            int length = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '0') cntZero++;
                else {
                    sb.append(c);
                    length++;
                }
            }

            s = Integer.toString(length, 2);
            cntConv++;

        }

        answer = new int[]{cntConv, cntZero};

        return answer;
    }
}