package Level1.크레인_인형뽑기_게임;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int order = moves[i] - 1;

            int pick = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][order] != 0) {
                    pick = board[j][order];
                    board[j][order] = 0;
                    break;
                }
            }

            if (pick != 0) {
                if (stack.size() != 0 && stack.peek() == pick) {
                    stack.pop();
                    answer += 2;
                } else stack.push(pick);
            }
        }
        return answer;
    }
}