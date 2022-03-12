package ps.programmers.level1;

import java.util.Arrays;

// 연습문제 - 문자열 내 p와 y의 개수
// 2022/03/13 01:24~01:31 = 7분
public class StringInPYNumber {
	boolean solution(String s) {
		String[] letters = s.toLowerCase().split("");
		long p = Arrays.stream(letters).filter(letter -> letter.equals("p")).count();
		long y = Arrays.stream(letters).filter(letter -> letter.equals("y")).count();
		return p==y;
	}
}
