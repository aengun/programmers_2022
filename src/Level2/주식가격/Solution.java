package Level2.주식가격;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] <= prices[j]) {
                    continue;
                } else break;
            }
        }

        return answer;
    }
}

// class Solution {
//     public int[] solution(int[] prices) {
//         int[] answer = new int[prices.length];

// 		for (int i = 0; i < prices.length; i++)
// 			for (int j = i + 1; j < prices.length; j++) {
// 				answer[i]++;
// 				if (prices[i] <= prices[j])
// 					continue;
// 				else
// 					break;
// 			}
//         return answer;
//     }
// }
