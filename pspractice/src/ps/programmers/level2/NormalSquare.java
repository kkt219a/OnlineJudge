package ps.programmers.level2;

import java.math.BigInteger;

// Summer/Winter Coding(2019) - 멀쩡한 사각형
// 2022/03/15 14:40 ~ : 규칙 못찾음 다시
public class NormalSquare {
	public long solution(int w, int h) {
		long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
		return (long)w*h-(w/gcd+h/gcd-1)*gcd;
	}
}
