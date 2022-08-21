package Level2.Level2.ps2의n제곱_배열_자르기;

class Solution_틀림 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        int index = 0; //그룹별 인덱스 (각 그룹은 n개씩)
        // n = 5인 경우
        // (1234) (2234) (3334) (4444) <<실제 배열
        // (0123) (0123) (0123) (0123) <<그룹의 인덱스
        // 그룹0   그룹1   그룹2   그룹3  <<q값에 따른 그룹 분류
        StringBuilder tmp = new StringBuilder();
        for (long i = left; i <= right; i++) {

            StringBuilder sb = new StringBuilder();

            long q = i / (long) n;
            long r = i % (long) n;

            for (long j = 0; j < q + 1; j++) {
                sb.append(q + 1);
            }

            for (long j = q + 1; j < n; j++) {
                sb.append(j + 1);
            }

            if (r == 0 && (q + 1) * n - 1 <= right) {
                tmp.append(sb.toString());
                i += n - 1;
            } else {
                tmp.append(sb.toString().charAt((int) r));
            }

        }

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Character.getNumericValue(tmp.toString().charAt(i));
        }

        return answer;
    }
}