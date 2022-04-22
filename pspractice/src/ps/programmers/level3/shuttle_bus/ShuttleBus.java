package ps.programmers.level3.shuttle_bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 셔틀버스
// 2022/04/22 18:40~19:45 = 65분
public class ShuttleBus {
	int startTime = 540;
	int nowPersonIdx = 0;
	public String solution(int n, int t, int m, String[] timetable) {
		List<Bus> buses = new ArrayList<>();
		for(int i=0;i<n;i++) {
			buses.add(new Bus(startTime+i*t,m));
		}
		List<Integer> waits = Arrays.stream(timetable).map(tt -> {
			String[] ttt = tt.split(":");
			return Integer.parseInt(ttt[0]) * 60 + Integer.parseInt(ttt[1]);
		}).sorted(Integer::compare).collect(Collectors.toList());
		waits.removeIf(w-> w > startTime+(t*n-1)); // 마지막 셔틀보다 늦게오는 애들 제거
		for(int i=0;i<n;i++) {
			Bus bus = buses.get(i);
			for(;nowPersonIdx<waits.size() && waits.get(nowPersonIdx) <= bus.arriveTime && bus.persons.size()!=bus.limitPerson;nowPersonIdx++) {
				bus.persons.add(waits.get(nowPersonIdx));
			}
			Collections.sort(bus.persons);
		}
		// 마지막 버스에서 내가 들어갈 자리가 있으면 버스 도착시간으로 들어가기
		if(buses.get(n-1).persons.size() < buses.get(n-1).limitPerson) {
			return getTime(buses.get(n-1).arriveTime);
		}
		return getTime(buses.get(n-1).persons.get(buses.get(n-1).persons.size()-1)-1);
	}

	public String getTime(Integer time) {
		return String.format("%02d", time/60)+ ":" + String.format("%02d", time%60);
	}

	class Bus {
		int arriveTime;
		int limitPerson;
		List<Integer> persons = new ArrayList<>();
		public Bus(int arriveTime, int limitPerson) {
			this.arriveTime = arriveTime;
			this.limitPerson = limitPerson;
		}
	}
}
