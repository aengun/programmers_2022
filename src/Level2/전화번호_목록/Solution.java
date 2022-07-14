package Level2.전화번호_목록;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for(int i = 0; i<phone_book.length; i++){
            for(int j = i+1; j<phone_book.length; j++){
                String a = phone_book[i];
                String b = phone_book[j];
                if(a.length() < b.length()){
                    if(b.indexOf(a) == 0) return false;
                } else {
                    if(a.indexOf(b) == 0) return false;
                }
            }
        }

        return answer;
    }
}

// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Map;
// class Solution {
//     public boolean solution(String[] phone_book) {
//         boolean answer = true;
//         int shortLength = 20;

// 		for (String s : phone_book)
// 			if (s.length() <= shortLength) {
// 				shortLength = s.length();
// 			}

// 		Map<String, Integer> map = new HashMap<>();
// 		List<String> list = new LinkedList<>();
// 		for (String s : phone_book) {
// 			String key = s.substring(0, shortLength);
// 			map.put(key, map.getOrDefault(key, 0) + 1);
// 			if (map.get(key) == 2)
// 				list.add(key);
// 		}

// 		for (String str : list)
// 			for (String number : phone_book)
// 				if (str.equals(number))
// 					return false;
//         return answer;
//     }
// }