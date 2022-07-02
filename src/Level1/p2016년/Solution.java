package Level1.p2016년;

class Solution {
    public String solution(int a, int b) {
        String answer = "";

        int[] months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = new String[]{"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        if (a == 1) {
            answer = days[(b - 1) % 7];
        } else {
            int tmpDays = 0;
            for (int i = 0; i < a - 1; i++) {
                tmpDays += months[i];
            }
            tmpDays += b;
            answer = days[(tmpDays - 1) % 7];
        }

        return answer;
    }
}

// import java.time.LocalDate;
// class Solution {
//     public String solution(int a, int b) {
//         String answer = "";
//         LocalDate day = LocalDate.of(2016, a, b);
//         answer = day.getDayOfWeek().toString().substring(0,3);
//         return answer;
//     }
// }