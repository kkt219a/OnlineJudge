package ps.programmers.level1;

import java.util.Arrays;

// 연습문제 - 평균 구하기
// 2022/03/14 01:48~01:49
public class FindAverage {
	public double solution(int[] arr) {
		return Arrays.stream(arr).average().getAsDouble();
	}
}
