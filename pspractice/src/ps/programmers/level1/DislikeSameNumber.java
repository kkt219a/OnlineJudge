package ps.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// 연습문제 - 같은 숫자는 싫어
// 2022/03/12 19:21~19:28 = 7분
public class DislikeSameNumber {
	public int[] solution(int []arr) {
		List<Integer> answers = new ArrayList<>();
		int lastNum = -1;
		for (int i : arr) {
			if(lastNum != i) {
				answers.add(i);
			}
			lastNum = i;
		}
		return answers.stream().mapToInt(Integer::intValue).toArray();
	}
}
