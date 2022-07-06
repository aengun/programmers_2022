package Level2.오픈채팅방;

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, String> hash = new HashMap<>();
        ArrayList<User> list = new ArrayList<>();

        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");

            if (tmp[0].equals("Change")) {
                hash.put(tmp[1], tmp[2]);
            } else if (tmp[0].equals("Enter")) {
                list.add(new User(tmp[0], tmp[1]));
                hash.put(tmp[1], tmp[2]);
            } else if (tmp[0].equals("Leave")) {
                list.add(new User(tmp[0], tmp[1]));
            }
        }

        answer = new String[list.size()];

        for (int i = 0; i < answer.length; i++) {
            StringBuilder sb = new StringBuilder();
            User tmp = list.get(i);
            if (tmp.action.equals("Enter")) {
                sb.append(hash.get(tmp.id) + "님이 들어왔습니다.");
            } else {
                sb.append(hash.get(tmp.id) + "님이 나갔습니다.");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}

class User {
    String action;
    String id;

    User(String action, String id) {
        this.action = action;
        this.id = id;
    }
}
