package Level2.조이스틱;

class Solution_못풂 {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int index; // 다음 값들을 확인할 때 사용
        int move = length - 1; // 좌우 움직임 수를 체크

        for(int i = 0; i < name.length(); i++){
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i + 1;
            // 연속되는 A 갯수 확인
            while(index < length && name.charAt(index) == 'A'){
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            move = Math.min(move, i * 2 + length - index);
            // 2022년 이전 테스트 케이스만 확인하면 여기까지해도 정답처리가 되기 때문에, 이전 정답들에는 여기까지만 정리되어 있지만,
            // BBBBAAAAAAAB 와 같이, 처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우까지 고려하려면 아래의 코드가 필요합니다.
            move = Math.min(move, (length - index) * 2 + i);
        }
        return answer + move;
    }
}

//class Solution {
//    public int solution(String name) {
//        int answer = 0;
//
//        char[] arr = name.toCharArray();
//        for(char c : arr){
//            if(c - 'A' > 12) {
//                answer += 'Z' - c + 1;
//            } else {
//                answer += c - 'A';
//            }
//            if(c != 'A')
//                answer++;
//        }
//        answer--;
//        return answer;
//    }
//}

//class Solution {
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().solution("JEROEN"	));
//        System.out.println(new Solution().solution("JAN"	));
//        System.out.println(new Solution().solution("BBAAAAAB"	));
//    }
//
//    public int solution(String name) {
//        int answer = 0;
//        char[] charName = name.toCharArray();
//        char[] criteria = new char[charName.length];
//        int[] count = new int[criteria.length];
//        for (int i = 0; i < criteria.length; i++)
//            criteria[i] = 'A';
//
//        for (int i = 0; i < count.length; i++)
//            if (charName[i] <= 'N')
//                count[i] = charName[i] - criteria[i];
//            else
//                count[i] = 'Z' - charName[i] + 1;
//
//        for (int i : count)
//            answer += i;
//
//        int[] check = new int[count.length];
//        for (int i = 0; i < check.length; i++)
//            if (count[i] != 0)
//                check[i] = 1;
//        System.out.println(Arrays.toString(check));
//        // 오른쪽 방향으로 갈 때
//        int pointer1 = 0;
//        for (int i = 0; i < check.length; i++) {
//            if (check[i] != 0)
//                pointer1 = i;
//        }
//        System.out.println(pointer1);
//
//        // 왼쪽 방향으로 갈 때
//        int pointer2 = 0;
//        for (int i = check.length - 1; i > 0; i--) {
//            if (check[i] != 0)
//                pointer2 = i;
//        }
//
//        pointer2 = check.length - pointer2;
//        System.out.println(pointer2);
//
//        if (pointer1 <= pointer2)
//            answer += pointer1;
//        else
//            answer += pointer2;
//        return answer;
//    }
//}