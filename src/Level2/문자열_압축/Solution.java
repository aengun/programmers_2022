package Level2.문자열_압축;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < s.length(); i++) {

            StringBuilder sb = new StringBuilder();

            String tmp = s.substring(0, i);

            int index = i;
            int num = 1;
            while (index < s.length()) {

                String tmp2;

                if (index + i <= s.length())
                    tmp2 = s.substring(index, index + i);
                else
                    tmp2 = s.substring(index);

                if (tmp.equals(tmp2)) {
                    num++;
                } else {
                    if (num == 1)
                        sb.append(tmp);
                    else
                        sb.append(num + tmp);

                    num = 1;
                    tmp = tmp2;
                }

                index += i;

                if (index >= s.length()) {
                    if (num != 1)
                        sb.append(num + tmp2);
                    else
                        sb.append(tmp2);
                }

            }

            answer = Math.min(answer, sb.toString().length());

        }

        if (answer == Integer.MAX_VALUE) answer = 1;

        return answer;
    }
}