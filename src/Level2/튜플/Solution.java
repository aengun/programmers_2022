package Level2.튜플;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        // "},{" 기준으로 분리한다, \\는 java.util.regex.PatternSyntaxException
        // exception을 피하기 위함임
        String[] tmpArr = s.split("\\},\\{");


        List<Tuple> list = new ArrayList<Tuple>();
        for (String str : tmpArr) {
            // 각 튜플을 저장(특수문자를 제외하고 숫자배열만 만들어 튜플 리스트에 저장)
            str = str.replaceAll("[^0-9,]", ""); // 숫자랑 , 빼고 제외
            List<Integer> tuple = new ArrayList<Integer>();

            for (String ss : str.split(",")) {
                tuple.add(Integer.parseInt(ss));
            }
            list.add(new Tuple(tuple));
        }

        List<Integer> answerList = new ArrayList<>();
        Collections.sort(list); // 원소의 개수 오름차순으로 정렬
        for (Tuple t : list) {
            for (int i : t.elements) {
                if (!answerList.contains(i))
                    answerList.add(i);
            }
        }

        answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

class Tuple implements Comparable<Tuple> {
    List<Integer> elements;

    Tuple(List<Integer> elements) {
        this.elements = elements;
    }

    @Override
    public int compareTo(Tuple o) {
        return this.elements.size() - o.elements.size();
    }
}

