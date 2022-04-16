package ps.programmers.level2.bridge_truck;

import java.util.LinkedList;
import java.util.Queue;

//스택/큐 - 다리를 지나는 트럭
// 2022/04/16 22:04~23:03, 틀려서 예외보고 끼워맞춰 품, 다시
public class BridgeTruckV2 {
	int nowTime = 0;

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Bridge bridge = new Bridge(weight, bridge_length);
		for (int truck_weight : truck_weights) {
			CarInfo car = new CarInfo(truck_weight);
			bridge.input(car);
			bridge.removeCar();
		}
		bridge.removeCars();
		return nowTime;
	}

	class Bridge {
		Queue<CarInfo> cars = new LinkedList<>();
		int weight = 0;
		int MAX_WEIGHT;
		int MAX_BRIDGE_LENGTH;

		public Bridge(int MAX_WEIGHT, int MAX_BRIDGE_LENGTH) {
			this.MAX_WEIGHT = MAX_WEIGHT;
			this.MAX_BRIDGE_LENGTH = MAX_BRIDGE_LENGTH;
		}

		public void input(CarInfo carInfo) {
			if(!output(carInfo)) {
				nowTime++;
			}
			carInfo.setEnterTime(nowTime);
			weight += carInfo.weight;
			cars.offer(carInfo);
		}

		public boolean output(CarInfo carInfo) {
			boolean out = false;
			while(!cars.isEmpty() && (weight + carInfo.weight > MAX_WEIGHT || cars.size() == MAX_BRIDGE_LENGTH)) {
				CarInfo poll = cars.remove();
				weight -= poll.weight;
				nowTime = poll.enterTime + MAX_BRIDGE_LENGTH;
				out = true;
			}
			return out;
		}

		public void removeCar() {
			while(!cars.isEmpty() && cars.peek().enterTime + MAX_BRIDGE_LENGTH <= nowTime) {
				CarInfo poll = cars.remove();
				weight -= poll.weight;
			}
		}

		public void removeCars() {
			while(!cars.isEmpty()) {
				CarInfo remove = cars.remove();
				nowTime = remove.enterTime + MAX_BRIDGE_LENGTH;
			}
		}
	}

	static class CarInfo {
		int enterTime;
		int weight;
		public CarInfo(int weight) {
			this.weight = weight;
		}

		public void setEnterTime(int enterTime) {
			this.enterTime = enterTime;
		}
	}
}
