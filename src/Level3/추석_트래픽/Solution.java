package Level3.추석_트래픽;

import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;

        //lines를 초단위로 변경
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].substring(11).replace(":", "").replace("s", "");
            int sec = Integer.parseInt(line.substring(0, 2)) * 3600
                    + Integer.parseInt(line.substring(2, 4)) * 60
                    + Integer.parseInt(line.substring(4, 6));
            lines[i] = sec + line.substring(6);
            // System.out.println(lines[i]);
        }

        for (int i = 0; i < lines.length; i++) {
            String[] split = lines[i].split(" ");
            double end = Double.parseDouble(split[0]) + 1;

            // 각 line의 end + 1초보다 start가 이전이면 count++;
            int cnt = 1; // 자기 자신은 무조건 포함
            for (int j = i + 1; j < lines.length; j++) {
                String[] split2 = lines[j].split(" ");
                double end2 = Double.parseDouble(split2[0]); // 종료시간
                double term = Double.parseDouble(split2[1]); // T
                double start = end2 - term + 0.001; // 시작시간 계산
                if (start < end) { // <=여야하는 거 아닌가? 예제 2번은 2개인데 테케는 1개라고함,,
                    // System.out.println(start + " / " + end);
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}