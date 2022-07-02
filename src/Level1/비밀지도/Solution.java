package Level1.비밀지도;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];

        boolean[][] map1 = new boolean[n][n];
        boolean[][] map2 = new boolean[n][n];

        for (int i = 0; i < arr1.length; i++) {
            int index1 = arr1.length - 1;
            int tmp = arr1[i];
            while (tmp > 0) {
                map1[i][index1] = (tmp % 2 == 1) ? true : false;
                tmp /= 2;
                index1--;
            }

            int index2 = arr2.length - 1;
            int tmp2 = arr2[i];
            while (tmp2 > 0) {
                map2[i][index2] = (tmp2 % 2 == 1) ? true : false;
                tmp2 /= 2;
                index2--;
            }
        }

        StringBuilder sb;

        for (int i = 0; i < map1.length; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < map1[0].length; j++) {
                if (map1[i][j] || map2[i][j]) sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}

// class Solution {
//     public String[] solution(int n, int[] arr1, int[] arr2) {
//         String[] answer = new String[arr1.length];

// 		for (int i = 0; i < arr1.length; i++) {
// 			String binaryString = Integer.toBinaryString(arr1[i] | arr2[i]);
// 			while (binaryString.length() < n)
// 				binaryString = "0" + binaryString;
// 			binaryString = binaryString.replaceAll("0", " ");
// 			binaryString = binaryString.replaceAll("1", "#");
// 			answer[i] = binaryString;
// 		}
//         return answer;
//     }
// }
