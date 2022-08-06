package Level2.소수_찾기;

import java.util.*;

class Solution {

    static int answer;
    static int max;
    static char[] arr;
    static boolean[] ch;
    static boolean[] visited;

    public int solution(String numbers) {
        answer = 0;

        arr = numbers.toCharArray();
        visited = new boolean[arr.length];
        Character[] arr2 = new Character[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        Arrays.sort(arr2, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr2[i];
        }

        max = Integer.parseInt(new String(arr));
        ch = new boolean[max + 1];
        ch[0] = true;
        ch[1] = true;
        // 에라토스테네스의 체
        for (int i = 2; i < max; i++) {
            for (int j = i * 2; j <= max; j += i) {
                if (!ch[j]) {
                    ch[j] = true;
                }
            }
        }

        // 길이가 1~max값의 길이만큼의 숫자를 순열로 만들기
        for (int i = 1; i <= Integer.toString(max).length(); i++) {
            char[] tmp = new char[i];
            DFS(i, 0, tmp); 
        }

        return answer;
    }

    public static void DFS(int i, int L, char[] tmp) {

        if (L == i) {
            // 순열이 완성되면 tmp를 String으로 만들고 그것을 다시 int로 변환한다.
            int num = Integer.parseInt(new String(tmp));
            // 변환된 숫자가 소수인지 판별
            // 중복이 있을 수 있으므로 ch배열에 true로 저장
            if (ch[num] == false) {
                ch[num] = true;
                answer++;
            }
        } else {
            for (int j = 0; j < arr.length; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    tmp[L] = arr[j];
                    DFS(i, L + 1, tmp);
                    visited[j] = false;
                }
            }
        }

    }
}