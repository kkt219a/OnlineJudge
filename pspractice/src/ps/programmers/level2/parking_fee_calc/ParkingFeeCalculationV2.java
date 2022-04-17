package ps.programmers.level2.parking_fee_calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 2022 KAKAO BLIND RECRUITMENT - 주차 요금 계산
// 2022/04/18 00:52 ~ 01:15 = 23분
public class ParkingFeeCalculationV2 {
	//번호판, 입차시간(분)
	Map<String, Integer> nowCars = new HashMap<>();
	//번호판, 누적시간(분)
	Map<String, Integer> accrueCars = new HashMap<>();
	List<Integer> feeList = new ArrayList<>();

	public int[] solution(int[] fees, String[] records) {
		for (String record : records) {
			String[] carInfo = record.split(" ");
			int time = getTime(carInfo[0]);
			if (carInfo[2].equals("IN")) {
				nowCars.put(carInfo[1], time);
			} else {
				Integer enterTime = nowCars.remove(carInfo[1]);
				accrueCars.put(carInfo[1], accrueCars.getOrDefault(carInfo[1], 0) + (time - enterTime));
			}
		}
		for (Map.Entry<String, Integer> car : nowCars.entrySet()) {
			Integer enterTime = car.getValue();
			accrueCars.put(car.getKey(), accrueCars.getOrDefault(car.getKey(), 0) + (1439 - enterTime));
		}
		ArrayList<String> keys = new ArrayList<>(accrueCars.keySet());
		Collections.sort(keys);
		for (String key : keys) {
			Integer accTime = accrueCars.get(key);
			if (accTime <= fees[0]) {
				feeList.add(fees[1]);
			} else {
				int fee = fees[1] + (int)Math.ceil((double)(accTime - fees[0]) / fees[2]) * fees[3];
				feeList.add(fee);
			}
		}
		return feeList.stream().mapToInt(Integer::intValue).toArray();
	}

	private int getTime(String s) {
		String[] split = s.split(":");
		return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
	}
}
