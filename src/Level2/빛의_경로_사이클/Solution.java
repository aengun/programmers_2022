package Level2.빛의_경로_사이클;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"SL", "LR"})));
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"S"})));
        System.out.println(Arrays.toString(new Solution().solution(new String[]{"R", "R"})));
    }

    //3:28
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽 위 순
    static String[] directions = {"down", "left", "up", "right"};
    static String[][] map; // 격자 지도
    static ArrayList<HashSet<Position>> setList;

    public int[] solution(String[] grid) {
        int[] answer = {};

        map = new String[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            map[i] = grid[i].split("");
        }

        List<Integer> answerList = new ArrayList<>();
        setList = new ArrayList<HashSet<Position>>();
        for (int i = 0; i < 4; i++) {
            Position start = new Position(0, 0, directions[i]);
            Position cur = getNextPosition(start);
            HashSet<Position> set = new HashSet<>();
            set.add(start);
            int length = move(start, cur, 1, set); // 시작, 현재 위치

            boolean test = true;
            for (HashSet<Position> s : setList) {
                if (s.size() != set.size()) continue;
                else {
                    boolean ch = true;
                    for (Position p : s) {
                        if (!set.contains(p)) {
                            ch = false;
                            break;
                        }
                    }
                    if (ch) test = false;
                }
            }
            if (test) {
                setList.add(set);
                answerList.add(length);
            }

        }
        answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static Position getNextPosition(Position cur) {

        int x = cur.x;
        int y = cur.y;
        String direction = cur.direction;
        if ("right".equals(direction)) {
            x = x;
            y += 1;
        } else if ("down".equals(direction)) {
            x += 1;
            y = y;
        } else if ("left".equals(direction)) {
            x = x;
            y -= 1;
        } else { // up
            x -= 1;
            y = y;
        }

        if (x < 0) x = map.length - 1;
        if (x == map.length) x = 0;
        if (y < 0) y = map[0].length - 1;
        if (y == map[0].length) y = 0;

        String newDirection;
        if (map[x][y].equals("L")) {
            if (direction.equals("up")) {
                newDirection = "left";
            } else if (direction.equals("down")) {
                newDirection = "right";
            } else if (direction.equals("left")) {
                newDirection = "down";
            } else {
                newDirection = "up";
            }
        } else if (map[x][y].equals("R")) {
            if (direction.equals("up")) {
                newDirection = "right";
            } else if (direction.equals("down")) {
                newDirection = "left";
            } else if (direction.equals("left")) {
                newDirection = "up";
            } else {
                newDirection = "down";
            }
        } else newDirection = direction;

        return new Position(x, y, newDirection);

    }

    public static int move(Position start, Position cur, int length, HashSet set) {
        Position next = getNextPosition(cur);
        if (start.equals(cur)) {
            return length;
        } else {
            set.add(cur);
            return move(start, next, length + 1, set);
        }
    }

}

class Position {
    int x;
    int y;
    String direction;

    Position(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return x + "," + y + "," + direction;
    }

    @Override
    public boolean equals(Object o) {
        Position tmp = (Position) o;
        if (this.x == tmp.x && this.y == tmp.y && this.direction.equals(tmp.direction)) {
            return true;
        } else return false;
    }
}
