package ps.programmers.dontknow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 입차되고 출차 내역 없으면 23:59에 출차된 것
 *
 * 기본시간 이하면 기본요금
 * 기본시간 초과하면 기본요금 + 초과시간에대해 단위시간마다 단위요금 청구
 * 초과시간이 단위시간으로 나눠떨어지지 않으면 올림
 * [a]: a보다 작지않은 최소 정수, 즉 올림
 *
 *
 * 주차요금 정수배열: fees
 * fees[0] = 기본시간(분) 1<=fees[0]<=1439
 * fees[0] = 기본요금(원) 1<=fees[0]<=100000
 * fees[0] = 단위시간(분) 1<=fees[0]<=1439
 * fees[0] = 단위요금(원) 1<=fees[0]<=10000
 *
 * 자동차 입 출차내역 문자열배열: records
 *
 * 차량 번호가 작은 자동차부터 청구할 주차요금 차례대로 정수배열에 담아 리턴
 */
public class Three {
    //차 번호가 키, 입차시간이 값
    HashMap<String,String> contents = new HashMap<>();
    // 차 번호가 키, 누적 주차시간이 값
    HashMap<String, Integer> carMinutes = new HashMap<>();
    // 차 번호가 키, 요금이 값
    HashMap<Integer, Integer> carFees = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        for (String record : records) {
            String[] split = record.split(" ");
            //입차해있다면
            if(contents.containsKey(split[1])){
                String inTime = contents.get(split[1]);
                carMinutes.put(split[1],carMinutes.getOrDefault(split[1],0)+getMinute(inTime,split[0]));
                contents.remove(split[1]);
            }else{
                contents.put(split[1],split[0]);
            }
        }
        // 출차안한애들 처리
        for (String s : contents.keySet()) {
            String inTime = contents.get(s);
            carMinutes.put(s,carMinutes.getOrDefault(s,0)+getMinute(inTime,"23:59"));
        }

        //요금 계산
        for (String s : carMinutes.keySet()) {
            int minutes = carMinutes.get(s);
            if(minutes<=fees[0]){
                carFees.put(Integer.parseInt(s),fees[1]);
            }else{
                int time = minutes - fees[0];
                int realFees = time/fees[2];
                if(time%fees[2]!=0){
                    realFees+=1;
                }
                int value = fees[1] + realFees * fees[3];
                carFees.put(Integer.parseInt(s),value);
            }
        }
        ArrayList<Integer> carFeeList = new ArrayList<>(carFees.keySet());
        Collections.sort(carFeeList);
        answer = new int[carFeeList.size()];
        for(int i=0;i<carFeeList.size();i++){
            answer[i] = carFees.get(carFeeList.get(i));
        }
        return answer;
    }

    public int getMinute(String inTime,String outTime){
        String[] split = inTime.split(":");
        int inTimeNew = (Integer.parseInt(split[0]) * 60) + Integer.parseInt(split[1]);
        String[] split2 = outTime.split(":");
        int outTimeNew = (Integer.parseInt(split2[0]) * 60) + Integer.parseInt(split2[1]);
        return outTimeNew-inTimeNew;
    }
}
