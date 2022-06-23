package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/23 해설 참조
public class P1082 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String[] dp;
	static int[] number;
	static int n, m;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		number = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n;i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		m = Integer.parseInt(br.readLine());
		dp = new String[m + 1];
		for (int i = 0; i < n; i++) {
			String is = String.valueOf(i);
			for (int j = number[i]; j <= m; j++) {
				dp[j] = comp(dp[j], is);
			}
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= number[j] && dp[i - number[j]] != null) {
					dp[i] = comp(dp[i], dp[i - number[j]] + dp[number[j]]);
				}
			}
		}
		System.out.println(new BigInteger(dp[m]));
	}

	private static String comp(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return s1 == null ? s2 : s1;
		}
		return new BigInteger(s1).compareTo(new BigInteger(s2)) > 0 ? s1 : s2;
	}
}
