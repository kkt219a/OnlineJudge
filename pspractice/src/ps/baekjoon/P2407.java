package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// 2022/06/09 20분
public class P2407 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().split(" ");
		BigInteger n = fact(Integer.parseInt(s[0]));
		BigInteger nMinusM = fact(Integer.parseInt(s[0]) - Integer.parseInt(s[1]));
		BigInteger m = fact(Integer.parseInt(s[1]));
		System.out.println(n.divide(nMinusM.multiply(m)));
	}

	private static BigInteger fact(int n) {
		BigInteger one = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			one = one.multiply(BigInteger.valueOf(i));
		}
		return one;
	}
}
