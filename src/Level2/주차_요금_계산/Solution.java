package Level2.주차_요금_계산;

import java.util.*;

class Solution {

    static HashMap<String, String> parkRecord = new HashMap<>(); // 차량 별 입출차 기록
    static HashMap<String, Integer> parkTime = new HashMap<>(); // 차량 별 주차 시간

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        for (String s : records) {

            String[] arr = s.split(" ");
            if (arr[2].equals("IN")) {
                //들어오는 차량이면 parkRecord에 add
                parkRecord.put(arr[1], arr[0]);
            } else {
                //나가는 차량이면
                String key = arr[1];
                String inTime = parkRecord.remove(key);
                String outTime = arr[0];
                int hour = Integer.parseInt(outTime.substring(0, 2)) - Integer.parseInt(inTime.substring(0, 2));
                int minute = Integer.parseInt(outTime.substring(3, 5)) - Integer.parseInt(inTime.substring(3, 5));
                //parkTime에 add
                parkTime.put(key, parkTime.getOrDefault(key, 0) + hour * 60 + minute);
            }
        }

        // 빠져나가지 않은 차가 있는 경우 23:59에 나간 것으로 계산
        for (String key : parkRecord.keySet()) {
            String inTime = parkRecord.get(key);
            String outTime = "23:59";
            int hour = Integer.parseInt(outTime.substring(0, 2)) - Integer.parseInt(inTime.substring(0, 2));
            int minute = Integer.parseInt(outTime.substring(3, 5)) - Integer.parseInt(inTime.substring(3, 5));
            parkTime.put(key, parkTime.getOrDefault(key, 0) + hour * 60 + minute);
        }

        ArrayList<Car> feeList = new ArrayList<>();

        for (String key : parkTime.keySet()) {
            int tmp = 0;
            int time = parkTime.get(key);
            if (time <= fees[0]) tmp += fees[1];
            else {
                tmp += fees[1];
                time -= fees[0];
                if (time % fees[2] == 0) {
                    tmp += time / fees[2] * fees[3];
                } else {
                    tmp += ((time / fees[2]) + 1) * fees[3];
                }
            }
            feeList.add(new Car(key, tmp));
        }

        Collections.sort(feeList);

        answer = new int[feeList.size()];
        for (int i = 0; i < feeList.size(); i++) {
            answer[i] = feeList.get(i).fee;
        }

        return answer;
    }
}

class Car implements Comparable<Car> {
    String carNum;//차량번호
    int fee;//요금

    Car(String carNum, int fee) {
        this.carNum = carNum;
        this.fee = fee;
    }

    @Override
    public int compareTo(Car o) {
        return this.carNum.compareTo(o.carNum);
    }

    @Override
    public String toString() {
        return "[" + this.carNum + " , " + this.fee + "]";
    }
}