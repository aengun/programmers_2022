package Level1.소수_찾기;

class Solution {
    public int solution(int n) {
        int answer = 0;

        boolean[] arr = new boolean[n + 1];
        for (int i = 2; i < n; i++) {
            for (int j = i * 2; j <= n; j = j + i) {
                arr[j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (arr[i] == false) answer++;
        }

        return answer;
    }
}

// class Solution {
//     public int solution(int n) {
//         int answer = 0;
//         boolean[] checked = new boolean[n + 1];

// 		for (int i = 2; i <= n; i++) {
// 			if (!checked[i])
// 				for (int j = i * 2; j <= n; j = j + i)
// 					checked[j] = true;
// 		}

// 		for(int i = 2;i<=n;i++)
// 			if(!checked[i])
// 				answer++;
//         return answer;
//     }
// }