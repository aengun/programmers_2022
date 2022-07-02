package Level1.나머지가_1이_되는_수_찾기;

class Solution {
    public int solution(int n) {
        int answer = 2;

        boolean flag = false;
        if (n % 2 == 1) return 2;

        while (!flag) {
            answer++;
            if (n % answer == 1) {
                flag = true;
            }
        }

        return answer;
    }
}

// 11 -> 2인 경우를 찾지 못했음