package ps.programmers.level3.chuseok_traffic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 추석 트래픽
// 2022/04/22 13:51~15:29 = 98분
public class ChuseokTraffic {
	int idx = 0;
	int maxProcessing = Integer.MIN_VALUE;
	List<Traffic> trafficList = new ArrayList<>();
	List<Traffic> nowTraffic = new ArrayList<>();
	public int solution(String[] lines) {
		for (String line : lines) {
			calcMsTime(line.split(" "));
		}
		trafficList.sort(Comparator.comparingLong(o -> o.time));
		for (Traffic traffic : trafficList) {
			//최대값 재처리
			maxProcessing = Math.max(nowTraffic.size(), maxProcessing);
			// 범위 안에 안들어오지만 아직 끝나지 않은 애들은 살려야한다
			nowTraffic.stream()
				.filter(t -> traffic.time - t.time >= 1000 && t.info == 'I')
				.forEach(t-> t.setTime(traffic.time-999));
			// 범위 안에 없거나, 종료되는 아이라면 제거
			nowTraffic.removeIf(t -> ((traffic.time - t.time >= 1000)&& t.info=='O') || t.idx == traffic.idx);
			nowTraffic.add(traffic);
		}
		return maxProcessing;
	}

	private void calcMsTime(String[] info) {
		String[] time = info[1].split(":");
		String[] msTime = time[2].split("\\.");
		long endTime = (Long.parseLong(time[0])*60*60*1000) + (Long.parseLong(time[1])*60*1000) + (Long.parseLong(msTime[0])*1000) + Long.parseLong(msTime[1]);
		long spendTime = (long)(Double.parseDouble(info[2].replace("s","")) * 1000);
		trafficList.add(new Traffic(idx,endTime-spendTime+1,'I'));
		trafficList.add(new Traffic(idx++,endTime,'O'));
	}

	static class Traffic {
		int idx;
		long time;
		char info;
		public Traffic(int idx, long time, char info) {
			this.idx = idx;
			this.time = time;
			this.info = info;
		}
		public void setTime(long time) {
			this.time = time;
		}
	}
}
