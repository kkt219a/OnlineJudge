package ps.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// 월간 코드 챌린지 시즌1 - 두 개 뽑아서 더하기
// 2022/03/12 18:48~18:54 = 6분
public class PickTwoAndAdd {
	public int[] solution(int[] numbers) {
		Set<Integer> set = new HashSet<>();
		for(int i=0;i< numbers.length;i++) {
			for(int j=i+1;j< numbers.length;j++) {
				set.add(numbers[i]+numbers[j]);
			}
		}
		List<Integer> integers = new ArrayList<>(set);
		Collections.sort(integers);
		return integers.stream().mapToInt(Integer::intValue).toArray();
	}
}
