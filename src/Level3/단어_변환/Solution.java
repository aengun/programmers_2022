package Level3.단어_변환;

import java.util.*;

class Solution {
    static int[] visited;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        visited = new int[words.length];
        Arrays.fill(visited, Integer.MAX_VALUE);
        answer = bfs(begin, target, words);

        return answer;
    }

    static int bfs(String begin, String target, String[] words) {

        int cnt = 0;

        Queue<Word> q = new LinkedList<>();

        q.add(new Word(begin, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Word tmp = q.poll();
                char[] tmpArr = tmp.w.toCharArray();
                // target이 나오면 리턴
                if (tmp.w.equals(target)) return tmp.step;
                for (int k = 0; k < words.length; k++) {
                    // 큐에서 꺼내온 단어와 word 배열에 있는 단어를 비교
                    String s = words[k];
                    if (s.equals(tmp.w)) continue;
                    char[] tmpArr2 = s.toCharArray();
                    int tmpCnt = 0; // 다른 문자의 개수
                    for (int j = 0; j < tmpArr.length; j++) {
                        if (tmpArr[j] != tmpArr2[j]) tmpCnt++;
                    }
                    // 차이가 1개이면 변환할 수 있는 경우
                    if (tmpCnt == 1) {
                        // 이미 방문했으나 더 빠른 경로가 아니라면 queue에 넣지 않음
                        if (visited[k] < tmp.step + 1) continue;
                        visited[k] = tmp.step + 1;
                        // System.out.println(tmp.w + " / " + s);
                        q.add(new Word(s, tmp.step + 1));
                    }
                }
                // System.out.println(Arrays.toString(visited));
            }
        }

        return cnt;

    }
}

class Word {
    String w;
    int step;

    Word(String w, int step) {
        this.w = w;
        this.step = step;
    }
}