package Level2.프린터;

import java.util.LinkedList;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(new Solution().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        LinkedList<Paper> list = new LinkedList<>();

        // 우선순위와 현재 순서를 가진 paper를 리스트에 추가
        for (int i = 0; i < priorities.length; i++) {
            list.add(new Paper(priorities[i], i));
        }

        boolean flag = true; // while문을 돌리기 위한 변수

        while (flag) {
            // 우선 한장을 뽑아본다
            Paper tmp = list.get(0);
            list.remove(0);
            int tmpP = tmp.priority;
            boolean isMax = true;
            // 리스트를 돌면서 우선순위가 더 높은 것이 있는 지 확인
            for (int i = 0; i < list.size(); i++) {
                Paper tmp2 = list.get(i);
                if (tmp2.priority > tmpP) {
                    isMax = false;
                    break;
                }
            }
            // 현재 paper가 우선순위가 가장 높으면 answer++ 아니면 리스트에 다시 추가(맨 뒤로 보냄)
            // 내가 찾던 paper면 while문 종료
            if (isMax) {
                answer++;
                if (tmp.order == location) {
                    flag = false;
                }
            } else {
                list.add(tmp);
            }
        }

        return answer;
    }
}

class Paper {
    int priority;
    int order;

    Paper(int priority, int order) {
        this.priority = priority;
        this.order = order;
    }
}

//import java.util.*;
// class Solution {
//     public int solution(int[] priorities, int location) {
//         int answer = 0;
// 		List<Prints> list = new LinkedList<>();
// 		for (int i = 0; i < priorities.length; i++) {
// 			list.add(new Prints(i, priorities[i]));
// 		}

// 		while (!list.isEmpty()) {
// 			Prints p = list.get(0);

// 			boolean isRemoved = false;
// 			for (int i = 1; i < list.size(); i++) {
// 				if (p.importance < list.get(i).importance) {
// 					// 중요도 높은게 있으면 맨 뒤로 보내기
// 					list.remove(0);
// 					list.add(p);
// 					isRemoved = true;
// 					break;
// 				}
// 			}

// 			if(isRemoved)
// 				continue;

// 			int maxImportance = 0;
// 			for (Prints print : list)
// 				if (print.importance > maxImportance)
// 					maxImportance = print.importance;

// 			if (list.get(0).location == location)
// 				break;

// 			if (list.get(0).importance == maxImportance) {
// 				list.remove(0);
// 				answer++;
// 			}

// 		}

// 		return answer + 1;
// 	}

// }

// class Prints {

// 	int location;
// 	int importance;

// 	public Prints(int location, int importance) {
// 		this.location = location;
// 		this.importance = importance;
// 	}

// 	@Override
// 	public String toString() {
// 		return "Prints [location=" + location + ", importance=" + importance + "]";
// 	}

// }