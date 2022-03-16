package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// 2019 카카오 개발자 겨울 인턴십 - 튜플
// 2022/03/16 22:37 ~ 23:00 = 23분
public class Tuple {
	public int[] solution(String s) {
		String[] split = s.split("},");
		List<String> ss = new ArrayList<>();
		Set<Integer> nums = new LinkedHashSet<>();
		for (String s1 : split) {
			s1 = s1.replace("{","").replace("}","");
			ss.add(s1);
		}
		ss.sort(Comparator.comparingInt(String::length));
		for (String s1 : ss) {
			String[] split1 = s1.split(",");
			for (String s2 : split1) {
				nums.add(Integer.parseInt(s2));
			}
		}
		return nums.stream().mapToInt(Integer::intValue).toArray();
	}
}
