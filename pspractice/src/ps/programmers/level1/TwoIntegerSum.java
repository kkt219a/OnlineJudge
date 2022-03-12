package ps.programmers.level1;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

// 연습문제 - 두 정수 사이의 합
// 2022/03/12 19:07~19:15 = 8분
public class TwoIntegerSum {
	public long solution(int a, int b) {
		return LongStream.rangeClosed(Math.min(a, b),Math.max(a, b))
			.reduce(Long::sum).getAsLong();
	}
}
