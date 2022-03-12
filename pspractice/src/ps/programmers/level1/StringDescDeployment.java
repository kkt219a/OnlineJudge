package ps.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

// 연습문제 - 문자열 내림차순으로 배치하기
// 2022/03/13 01:32~01:40 = 8분
public class StringDescDeployment {
	public String solution(String s) {
		return Arrays.stream(s.split(""))
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.joining());
	}
}
