package Level2.단체사진_찍기;

class Solution_시간초과 {

    static char[] friends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int answer;
    static String[] datas;
    static boolean[] visited;
    static char[] arr;

    public int solution(int n, String[] data) {
        answer = 0;
        datas = data;
        arr = new char[friends.length];
        visited = new boolean[friends.length];

        DFS(0);

        return answer;
    }

    static void DFS(int L) {

        if (L == 8) {
            int index1 = 0;
            int index2 = 0;
            char operator;
            int distance;
            boolean flag = true;

            for (String s : datas) {

                for (int i = 0; i < 8; i++) {
                    if (arr[i] == s.charAt(0)) index1 = i;
                    if (arr[i] == s.charAt(2)) index2 = i;
                }
                
                operator = s.charAt(3);
                distance = s.charAt(4) - '0' + 1;

                if (operator == '=') {
                    if (Math.abs(index1 - index2) != distance) flag = false;
                } else if (operator == '>') {
                    if (Math.abs(index1 - index2) <= distance) flag = false;
                } else {
                    if (Math.abs(index1 - index2) >= distance) flag = false;
                }
            }

            if (flag) {
                answer++;
            }

        } else {
            for (int i = 0; i < 8; i++) {
                if (visited[i] == false) {
                    visited[i] = true;
                    arr[L] = friends[i];
                    DFS(L + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution_시간초과().solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(new Solution_시간초과().solution(2, new String[]{"M~C<2", "C~M>1"}));
    }

}