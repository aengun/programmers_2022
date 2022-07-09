package Level2.타겟_넘버;

class Solution {

    static int n;
    static int[] num;
    static int total;
    static int answer;

    public int solution(int[] numbers, int target) {
        answer = 0;

        n = numbers.length;
        num = numbers;
        total = target;

        DFS(0, 0);

        return answer;
    }

    static void DFS(int L, int sum) {

        if (L == n) {
            if (sum == total) answer++;
        } else {
            DFS(L + 1, sum + num[L]);
            DFS(L + 1, sum - num[L]);
        }

    }
}

// class Solution {
//     public int solution(int[] numbers, int target) {
//         int answer = 0;
//         int depth = 0;
// 		answer = dfs(numbers, target, depth);

// 		return answer;
// 	}

// 	private static int dfs(int[] numbers, int target, int depth) {
// 		int result = 0;

// 		if (depth == numbers.length)
// 			if (result == target)
// 				return 1;
// 			else
// 				return 0;

// 		result += dfs(numbers, target - numbers[depth], depth + 1);
// 		result += dfs(numbers, target + numbers[depth], depth + 1);

// 		return result;
// 	}

// }
