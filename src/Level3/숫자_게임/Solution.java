package Level3.숫자_게임;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] A = {1,1,1,1,2,3,4,5};
        int[] B = {1,1,1,1,2,4,4,5};
        System.out.println(new Solution().solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        ArrayList<Integer> aList = new ArrayList<>();
        ArrayList<Integer> bList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            aList.add(A[i]);
            bList.add(B[i]);
        }

        Collections.sort(aList);
        Collections.sort(bList);
        // b는 최대한 작은 수로 a를 이겨야 한다
        while (bList.size() != 0) {
            int a = aList.remove(0);
            int b = bList.remove(0);
            if (b > a) {
                answer++;
                continue;
            } else {
                while (b <= a) {
                    // 정렬된 리스트에서 b가 a보다 커질 때까지 꺼낸다
                    if (bList.size() == 0) break;
                    b = bList.remove(0);
                }
                if (b > a)
                    answer++;
            }
        }

        return answer;
    }
}