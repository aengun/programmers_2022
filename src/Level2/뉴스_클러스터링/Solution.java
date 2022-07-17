package Level2.뉴스_클러스터링;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
//        new Solution().solution("FRANCE", "french");
//        new Solution().solution("handshake", "shake hands");
        new Solution().solution("aa1+aa2", "AAAA12");
//        new Solution().solution("E=M*C^2", "e=m*c^2");
    }

    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int sum1 = 0;
        int sum2 = 0;

        for(int i = 0; i< str1.length()-1; i++){
            String tmp = str1.substring(i, i+2);
            tmp = tmp.replaceAll("[^a-z]","");
            if(tmp.length() != 2) continue;
            map1.put(tmp, map1.getOrDefault(tmp,0)+1);
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
            if(k != null){
                sum+= Math.min(k, map1.get(key));
            }
        }

        if(sum1 == 0 && sum2 == 0) return 65536;
        answer = sum * 65536 / (sum1+sum2-sum);

        return answer;
    }
}
