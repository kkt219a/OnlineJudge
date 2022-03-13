package ps.programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

// 연습문제 - 정수 내림차순으로 배치하기
// 2022/03/14 00:52~01:00
public class IntegerDescDeployment {
	public long solution(long n) {
		return Long.parseLong(Arrays.stream(String.valueOf(n).split(""))
			.sorted(Comparator.reverseOrder())
			.collect(Collectors.joining()));
	}
}
