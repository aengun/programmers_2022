package Level3.불량사용자;

import java.util.*;

class Solution {

    static ArrayList<ArrayList<String>> list;
    static int numOfBannedId;
    static ArrayList<String> tmpAnswerList;
    static HashSet<String> answerSet = new HashSet<>(); //

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;

        numOfBannedId = banned_id.length;

        list = new ArrayList<>();

        for (int i = 0; i < banned_id.length; i++) {
            list.add(new ArrayList<String>());

            String str = banned_id[i];

            int strLen = str.length();
            boolean[] starArr = new boolean[strLen];
            for (int j = 0; j < strLen; j++) {
                if (str.charAt(j) == '*') {
                    starArr[j] = true;
                }
            }

            for (String id : user_id) {
                if (id.length() != str.length()) {
                    continue;
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < strLen; j++) {
                        if (starArr[j]) {
                            sb.append('*');
                        } else {
                            sb.append(id.charAt(j));
                        }
                    }
                    if (str.equals(sb.toString())) {
                        list.get(i).add(id);
                    }
                }
            }

        }

        tmpAnswerList = new ArrayList<>();

        // for(ArrayList<String> l : list){
        //     System.out.println(l);
        // }

        dfs(0);
        answer = answerSet.size();
        return answer;
    }

    static void dfs(int L) {
        if (L == list.size()) {
            ArrayList<String> answerList = (ArrayList<String>) tmpAnswerList.clone();
            Collections.sort(answerList);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < answerList.size() - 1; i++) {
                if (answerList.get(i).equals(answerList.get(i + 1))) return;
                sb.append(answerList.get(i));
            }
            sb.append(answerList.get(answerList.size() - 1));
            if (!answerSet.contains(sb.toString())) {
                answerSet.add(sb.toString());
            }

            // System.out.println(answerList);

        } else {
            for (int i = 0; i < list.get(L).size(); i++) {
                tmpAnswerList.add(list.get(L).get(i));
                dfs(L + 1);
                tmpAnswerList.remove(L);
            }
        }
    }

}