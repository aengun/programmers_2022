package Level1.숫자_문자열과_영단어;

public class Solution {
    public int solution(String s) {
        // 2022 06 20
        int answer = 0;

        String[][] list = new String[][]{
                {"0", "zero"},
                {"1", "one"},
                {"2", "two"},
                {"3", "three"},
                {"4", "four"},
                {"5", "five"},
                {"6", "six"},
                {"7", "seven"},
                {"8", "eight"},
                {"9", "nine"}
        };

        for (int i = 0; i < list.length; i++) {
            s = s.replace(list[i][1], list[i][0]);
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}
