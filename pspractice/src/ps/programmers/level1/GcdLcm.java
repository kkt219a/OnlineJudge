package ps.programmers.level1;

import java.math.BigInteger;

// 연습문제 - 최대공약수와 최소공배수
// 2022/03/14 01:32~01:35
public class GcdLcm {
	public int[] solution(int n, int m) {
		int gcd = BigInteger.valueOf(n).gcd(BigInteger.valueOf(m)).intValue();
		return new int[]{gcd, (n*m)/gcd};
	}
}
