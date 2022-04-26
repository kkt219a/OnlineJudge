package ps.programmers.level3.jewelry_shopping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 2020 카카오 인턴십 - 보석 쇼핑
// 풀이 참고
public class JewelryShopping {
	long size;
	Map<String, Integer> jewelryMap = new HashMap<>();
	int start = 1, end = 1;
	int ansStart = Integer.MAX_VALUE / 10, ansEnd = Integer.MAX_VALUE / 3;

	public int[] solution(String[] gems) {
		size = Arrays.stream(gems).distinct().count();
		for (; end <= gems.length; end++) {
			jewelryMap.put(gems[end - 1], jewelryMap.getOrDefault(gems[end - 1], 0) + 1);
			while (jewelryMap.size() == size && start <= gems.length) {
				if (end - start < ansEnd - ansStart || (end - start == ansEnd - ansStart && start < ansStart)) {
					ansStart = start;
					ansEnd = end;
				}
				Integer integer = jewelryMap.get(gems[start - 1]);
				if (integer == 1) {
					jewelryMap.remove(gems[start - 1]);
				} else {
					jewelryMap.put(gems[start - 1], integer - 1);
				}
				start++;
			}
		}
		return new int[] {ansStart, ansEnd};
	}
}
