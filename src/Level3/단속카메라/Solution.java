package Level3.단속카메라;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        ArrayList<Car> list = new ArrayList<>();

        for (int[] r : routes) {
            int s = r[0];
            int e = r[1];
            Car c = new Car(s, e);
            list.add(c);
        }
        // System.out.println(list);
        Collections.sort(list);
        // System.out.println(list);

        Car first = list.remove(0);

        int camera = first.e;
        answer++;

        for (Car c : list) {
            if (c.s <= camera) {
                continue;
            } else {
                answer++;
                camera = c.e;
            }
        }

        return answer;
    }
}

class Car implements Comparable<Car> {
    int s;
    int e;

    Car(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Car c) {
        if (c.e != this.e) {
            return this.e - c.e;
        } else {
            return this.s - c.s;
        }
    }

    @Override
    public String toString() {
        return "[s : " + s + " / e : " + e + "]";
    }
}