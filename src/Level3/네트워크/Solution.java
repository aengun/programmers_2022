package Level3.네트워크;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, visited, computers);
            }
        }

        return answer;
    }

    static void dfs(int node, boolean[] visited, int[][] computers) {

        visited[node] = true;

        for (int i = 0; i < computers.length; i++) {
            if (visited[i] == false && computers[node][i] == 1) {
                dfs(i, visited, computers);
            }
        }

    }
}

// class Solution {
//     public int solution(int n, int[][] computers) {
//         int answer = 0;
//         boolean[] checked = new boolean[n];

// 		for (int i = 0; i < n; i++) {
// 			if (!checked[i]) {
// 				dfs(computers, i, checked);
// 				answer++;
// 			}
// 		}

// 		return answer;
// 	}

// 	static void dfs(int[][] computers, int i, boolean[] checked) {

// 		checked[i] = true;

// 		for (int j = 0; j < computers.length; j++) {
// 			if(i!=j && computers[i][j] == 1 && checked[j] == false) {
// 				dfs(computers, j, checked);
// 			}
// 		}

// 	}
// }