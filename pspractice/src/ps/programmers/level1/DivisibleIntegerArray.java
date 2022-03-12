package ps.programmers.level1;

import java.util.ArrayList;
import java.util.List;

// 연습문제 - 나누어 떨어지는 숫자 배열
// 2022/03/12 19:17~19:19 = 2분
public class DivisibleIntegerArray {
	public int[] solution(int[] arr, int divisor) {
		List<Integer> answers = new ArrayList<>();
		for (int i : arr) {
			if(i%divisor==0) {
				answers.add(i);
			}
		}
		if(answers.size() == 0) {
			answers.add(-1);
		}
		return answers.stream().sorted().mapToInt(Integer::intValue).toArray();
	}
}
