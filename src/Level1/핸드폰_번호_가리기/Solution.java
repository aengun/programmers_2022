package Level1.핸드폰_번호_가리기;

class Solution {
    public String solution(String phone_number) {
        String answer = "";

        int len = phone_number.length();
        phone_number = phone_number.substring(len - 4);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 4; i++) {
            sb.append("*");
        }

        sb.append(phone_number);

        answer = sb.toString();

        return answer;
    }
}