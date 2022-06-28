package Level1.키패드_누르기;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        Position[] arr = new Position[]{
                new Position(3, 1), //0
                new Position(0, 0), //1
                new Position(0, 1), //2
                new Position(0, 2), //3
                new Position(1, 0), //4
                new Position(1, 1), //5
                new Position(1, 2), //6
                new Position(2, 0), //7
                new Position(2, 1), //8
                new Position(2, 2), //9
                new Position(3, 0), //*
                new Position(3, 2)  //#
        };

        int lp = 10;
        int rp = 11;

        for (int i = 0; i < numbers.length; i++) {
            int tmp = numbers[i];
            if (tmp == 1 || tmp == 4 || tmp == 7) {
                sb.append("L");
                lp = tmp;
            } else if (tmp == 3 || tmp == 6 || tmp == 9) {
                sb.append("R");
                rp = tmp;
            } else {
                //왼손과 다음 번호까지 거리
                int ld = Math.abs(arr[tmp].x - arr[lp].x) + Math.abs(arr[tmp].y - arr[lp].y);
                int rd = Math.abs(arr[tmp].x - arr[rp].x) + Math.abs(arr[tmp].y - arr[rp].y);
                if (ld > rd) {
                    sb.append("R");
                    rp = tmp;
                } else if (ld < rd) {
                    sb.append("L");
                    lp = tmp;
                } else {
                    if (hand.equals("right")) {
                        sb.append("R");
                        rp = tmp;
                    } else {
                        sb.append("L");
                        lp = tmp;
                    }
                }

            }
        }

        answer = sb.toString();

        return answer;
    }
}

class Position {
    int x;
    int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
