import java.util.*;

class Solution {

    static ArrayList<ArrayList<String>> list;
    static ArrayList<String> tmp = new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<String> l1 = new ArrayList<>();
        l1.add("a");
        l1.add("b");
        l1.add("c");
        ArrayList<String> l2 = new ArrayList<>();
        l2.add("가");
        l2.add("나");
        l2.add("다");
        l2.add("라");
        list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        dfs(0);
    }

    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].indexOf(phone_book[i]) == 0) return false;
        }

        return answer;
    }
}
