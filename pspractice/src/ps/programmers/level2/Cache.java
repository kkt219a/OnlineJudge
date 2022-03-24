package ps.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// 2018 KAKAO BLIND RECRUITMENT - [1차] 캐시
// 2022/03/23 09:57~10:18 = 21분 - 맞추긴했는데... 다시!
public class Cache {
	public int solution(int cacheSize, String[] cities) {
		List<String> caches = new ArrayList<>();
		int answer = 0;
		for (String city : cities) {
			city = city.toLowerCase();
			if(caches.contains(city)) {
				caches.remove(city);
				caches.add(city);
				answer += 1;
				continue;
			}
			else if(cacheSize!=0 && caches.size()==cacheSize) {
				caches.remove(0);
				caches.add(city);
			} else if(cacheSize != 0) {
				caches.add(city);
			}
			answer += 5;;
		}
		return answer;
	}

}
