package Level2.순위_검색;

import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};

        ArrayList<Applicant> list = new ArrayList<>();
        for (String s : info) {
            String[] tmp = s.split(" ");
            list.add(new Applicant(tmp[0], tmp[1], tmp[2], tmp[3], Integer.parseInt(tmp[4])));
        }

        answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            String[] tmpQuery = query[i].split(" ");
            ArrayList<Applicant> list0 = new ArrayList<>(list);

            // 1단계 :  언어로 거른다.
            ArrayList<Applicant> list1 = new ArrayList<>();
            if ("-".equals(tmpQuery[0])) list1 = list0;
            else {
                for (Applicant a : list0) {
                    if (a.lang.equals(tmpQuery[0])) list1.add(a);
                }
            }


            // 2단계
            ArrayList<Applicant> list2 = new ArrayList<>();
            if ("-".equals(tmpQuery[2])) list2 = list1;
            else {
                for (Applicant a : list1) {
                    if (a.task.equals(tmpQuery[2])) list2.add(a);
                }
            }

            // 3단계
            ArrayList<Applicant> list3 = new ArrayList<>();
            if ("-".equals(tmpQuery[4])) list3 = list2;
            else {
                for (Applicant a : list2) {
                    if (a.career.equals(tmpQuery[4])) list3.add(a);
                }
            }
            // 4단계
            ArrayList<Applicant> list4 = new ArrayList<>();
            if ("-".equals(tmpQuery[6])) list4 = list3;
            else {
                for (Applicant a : list3) {
                    if (a.soulFood.equals(tmpQuery[6])) list4.add(a);
                }
            }
            // 5단계
            ArrayList<Applicant> list5 = new ArrayList<>();
            if ("-".equals(tmpQuery[7])) list5 = list4;
            else {
                for (Applicant a : list4) {
                    if (a.score >= Integer.parseInt(tmpQuery[7])) list5.add(a);
                }
            }

            answer[i] = list5.size();

        }

        return answer;
    }
}

class Applicant {
    String lang; //djsdj
    String task; //직무
    String career; //경력
    String soulFood; //소울푸드
    int score; //점수

    Applicant(String lang, String task, String career, String soulFood, int score) {
        this.lang = lang;
        this.task = task;
        this.career = career;
        this.soulFood = soulFood;
        this.score = score;
    }

    @Override
    public String toString() {
        return this.lang + "/" + this.task + "/" + this.career + "/" + this.soulFood + "/" + this.score;
    }
}