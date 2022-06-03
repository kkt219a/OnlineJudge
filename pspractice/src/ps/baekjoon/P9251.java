package ps.baekjoon;

import java.io.*;

// 2022/06/03 19:04 ~ 19:30 = 26분
public class P9251 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] a, b;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		dp = new int[a.length + 1][b.length + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = a[i - 1] == b[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		System.out.println(dp[a.length][b.length]);
	}
}
