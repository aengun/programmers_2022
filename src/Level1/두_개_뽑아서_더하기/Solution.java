package Level1.두_개_뽑아서_더하기;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 4, 1}));
    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                treeSet.add(numbers[i] + numbers[j]);
            }
        }

        answer = new int[treeSet.size()];
        int index = 0;
        Iterator iter = treeSet.iterator();

        while (iter.hasNext()) {
            Integer a = (Integer) iter.next();
            int b = a;
            answer[index] = b;
            index++;
        }

        return answer;
    }
}

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Set;
// import java.util.TreeSet;
// import java.util.stream.Collectors;
// class Solution {
//     public int[] solution(int[] numbers) {
//         int[] answer = {};
//         List<Integer> newNumbers = Arrays.stream(numbers).boxed().collect(Collectors.toList());

// 		Set<Integer> set = new TreeSet<>();

// 		for (int i = 0; i < newNumbers.size(); i++)
// 			for (int j = i+1; j < newNumbers.size(); j++)
// 					set.add(newNumbers.get(i) + newNumbers.get(j));

// 		answer = set.stream().mapToInt(i->i).toArray();
//         return answer;
//     }
// }
