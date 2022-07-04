package Level1.나누어_떨어지는_숫자_배열;

import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        Set<Integer> set = new TreeSet<>();
        for (int i : arr) {
            if (i % divisor == 0) set.add(i);
        }

        if (set.size() == 0) return new int[]{-1};

        answer = new int[set.size()];

        Iterator<Integer> iter = set.iterator();

        int index = 0;

        while (iter.hasNext()) {
            Integer k = iter.next();
            answer[index] = k;
            index++;
        }

        return answer;
    }
}

// import java.util.*;

// class Solution {
//     public int[] solution(int[] arr, int divisor) {
//         int[] answer = {};
//         Arrays.sort(arr);
//         List<Integer> list = new ArrayList<>();

// 		for(int i : arr)
// 			if(i%divisor == 0)
// 				list.add(i);

// 		if(list.size() == 0)
// 			list.add(-1);

// 		answer =  list.stream().mapToInt(i->i).toArray();
//         return answer;
//     }
// }