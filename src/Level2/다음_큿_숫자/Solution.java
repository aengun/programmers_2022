package Level2.다음_큿_숫자;

class Solution {
    public int solution(int n) {
        int answer = 0;

        String s = Integer.toBinaryString(n);
        int sNum = 0; //n의 1의 개수

        for (char c : s.toCharArray()) {
            if (c == '1') sNum++;
        }

        int num = n + 1;
        while (true) {

            String s2 = Integer.toBinaryString(num);
            int s2Num = 0;

            for (char c : s2.toCharArray()) {
                if (c == '1') s2Num++;
            }

            if (s2Num == sNum) {
                answer = num;
                break;
            }

            num++;

        }

        return answer;
    }
}

// class Solution {
//     public int solution(int n) {
//         int answer = n + 1;

// 		String nToBin = Integer.toBinaryString(n);
// 		int nCnt = 0;
// 		for (int i = 0; i < nToBin.length(); i++)
// 			if (nToBin.charAt(i) == '1')
// 				nCnt++;

// 		while (true) {
// 			String n2ToBin = Integer.toBinaryString(answer);
// 			int n2Cnt = 0;
// 			for (int i = 0; i < n2ToBin.length(); i++)
// 				if (n2ToBin.charAt(i) == '1')
// 					n2Cnt++;

// 			if (nCnt == n2Cnt)
// 				break;
// 			else
// 				answer++;
// 		}

//         return answer;
//     }
// }