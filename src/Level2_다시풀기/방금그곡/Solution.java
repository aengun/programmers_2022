package Level2_다시풀기.방금그곡;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";

        int maxLength = 0;

        m = change(m);
        for (String music : musicinfos) {

            String[] arr = music.split(",");
            // 재생 시간 계산
            String[] startTime = arr[0].split(":");
            String[] endTime = arr[1].split(":");
            int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);
            int time = end - start;

            String melody = ""; // 실제 연주된 음악
            arr[3] = change(arr[3]);
            int tmpLength = arr[3].length();
            if (time > arr[3].length()) {
                StringBuilder sb = new StringBuilder();
                // 나눈 몫 만큼 악보 처음부터 반복
                for (int i = 0; i < time / arr[3].length(); i++)
                    sb.append(arr[3]);

                sb.append(arr[3].substring(0, time % arr[3].length()));
                melody = sb.toString();
            } else {
                melody = arr[3].substring(0, time);
            }

            if (melody.contains(m) && maxLength < time) {
                answer = arr[2]; // 제목
                maxLength = time;
            }

        }

        if (answer.equals("")) answer = "(None)";

        return answer;
    }

    static String change(String s) {
        s = s.replaceAll("C#", "H");
        s = s.replaceAll("D#", "I");
        s = s.replaceAll("H#", "J");
        s = s.replaceAll("G#", "K");
        s = s.replaceAll("A#", "L");
        return s;
    }

}