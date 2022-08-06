package Level2.뉴스_클러스터링;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution("FRANCE", "french"));;
        System.out.println(new Solution().solution("aa1+aa2", "AAAA12"));;
        System.out.println(new Solution().solution("aa1+aa2", "AAAA12"));;
        System.out.println(new Solution().solution("E=M*C^2", "e=m*c^2"));;
    }

    public int solution(String str1, String str2) {
        int answer = 0;

        // 우선 모두 소문자로 만듦
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i< str1.length()-1; i++){
            //두 글자씩 끊는다
            String tmp = str1.substring(i, i+2);
            //영문자가 아닌 것은 제외
            tmp = tmp.replaceAll("[^a-z]","");
            //문자가 제거되면 길이가 2가 안되므로 넘어간다
            if(tmp.length() != 2) continue;
            //map에 저장
            map1.put(tmp, map1.getOrDefault(tmp,0)+1);
            //집합1의 개수
            sum1++;
        }

        for(int i = 0; i< str2.length()-1; i++){
            String tmp = str2.substring(i, i+2);
            tmp = tmp.replaceAll("[^a-z]","");
            if(tmp.length() != 2) continue;
            map2.put(tmp, map2.getOrDefault(tmp,0)+1);
            sum2++;
        }

        int sum = 0; //공통집합 개수
        for(String key : map1.keySet()){
            Integer k = map2.get(key);
            // 공통원소인 경우 각 map에서 최소 value값을 sum에 더한다
            if(k != null){
                sum+= Math.min(k, map1.get(key));
            }
        }
//         System.out.println(map1.toString());
//         System.out.println(map2.toString());
//         System.out.println(sum1 + " / " + sum2 + " / "+sum);
        if(sum1 == 0 && sum2 == 0) return 65536;
        answer = sum * 65536 / (sum1+sum2-sum);

        return answer;
    }
}
