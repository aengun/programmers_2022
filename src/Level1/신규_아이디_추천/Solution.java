package Level1.신규_아이디_추천;

class Solution {
    public String solution(String new_id) {
        String answer = "";

        //1단계
        new_id = new_id.toLowerCase();

        //2단계
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char tmp = new_id.charAt(i);
            if ((('a' <= tmp && tmp <= 'z') || ('0' <= tmp && tmp <= '9') || tmp == '-' || tmp == '_' || tmp == '.'))
                sb.append(tmp);
        }

        new_id = sb.toString();

        //3단계
        sb = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            char tmp = new_id.charAt(i);
            if (i == new_id.length() - 1) {
                sb.append(tmp);
            } else {
                if (tmp == '.' && new_id.charAt(i + 1) == '.') {
                    continue;
                } else sb.append(tmp);
            }
        }

        new_id = sb.toString();

        //4단계
        if (new_id.length() != 0 && new_id.charAt(0) == '.') new_id = new_id.substring(1);
        if (new_id.length() != 0 && new_id.charAt(new_id.length() - 1) == '.')
            new_id = new_id.substring(0, new_id.length() - 1);

        //5단계
        if (new_id.length() == 0) new_id = "a";

        //6단계
        if (new_id.length() > 15) new_id = new_id.substring(0, 15);
        if (new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, 14);

        //7단계
        if (new_id.length() <= 2) {
            char tmp = new_id.charAt(new_id.length() - 1);

            sb = new StringBuilder();
            for (int i = 0; i < new_id.length(); i++) {
                sb.append(new_id.charAt(i));
            }

            while (sb.length() < 3) {
                sb.append(tmp);
            }

            new_id = sb.toString();
        }

        answer = new_id;

        return answer;
    }
}
