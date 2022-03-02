package ps.programmers.level2;

import java.util.*;
// 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산
// 2022/03/02 18:34 ~ 19:09 = 35분

public class ParkingFeeCalculation {
	public int[] solution(int[] fees, String[] records) {
		List<Integer> answers = new ArrayList<>();
		Map<String,Integer> carInfo = new HashMap<>();
		Map<String,Integer> accumulatedParking = new HashMap<>();
		Map<String,Integer> feeInfo = new HashMap<>();
		for (String record : records) {
			String[] recordArray = record.split(" ");
			if(recordArray[2].equals("IN")) {
				carInfo.put(recordArray[1], getTime(recordArray[0]));
			} else {
				Integer inTime = carInfo.remove(recordArray[1]);
				int realTime = getTime(recordArray[0])-inTime;
				accumulatedParking.put(recordArray[1],accumulatedParking.getOrDefault(recordArray[1],0)+realTime);
			}
		}
		for (Map.Entry<String, Integer> entry : carInfo.entrySet()) {
			Integer inTime = carInfo.get(entry.getKey());
			int realTime = getTime("23:59")-inTime;
			accumulatedParking.put(entry.getKey(), accumulatedParking.getOrDefault(entry.getKey(),0)+realTime);
		}
		for (Map.Entry<String, Integer> entry : accumulatedParking.entrySet()) {
			feeInfo.put(entry.getKey(),calculateFee(entry.getValue(), fees));
		}
		List<String> keyList = new ArrayList<>(feeInfo.keySet());
		Collections.sort(keyList);
		for (String key : keyList) {
			answers.add(feeInfo.get(key));
		}
		return Arrays.stream(answers.toArray(new Integer[0]))
			.mapToInt(Integer::intValue).toArray();
	}

	private int calculateFee(int realTime, int[] fees) {
		int fee = fees[1];
		double remainingTime = realTime - fees[0];
		if(remainingTime<0) {
			return fee;
		}
		return fee+((int)Math.ceil(remainingTime/fees[2])*fees[3]);
	}

	public int getTime(String time) {
		String[] timeArray = time.split(":");
		return Integer.parseInt(timeArray[0]) * 60 + Integer.parseInt(timeArray[1]);
	}
}
