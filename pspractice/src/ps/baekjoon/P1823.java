package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/06/02 18:30 ~ 해설 참조
public class P1823 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp;
	static int[] rices;
	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[n + 1][n + 1];
		rices = new int[n + 1];
		for (int y = 1; y <= n; y++) {
			rices[y] = Integer.parseInt(br.readLine());
			dp[y][y] = rices[y] * n;
			for (int x = y - 1; x > 0; x--) {
				dp[x][y] = Math.max(dp[x][y - 1] + rices[y] * (n - y + x), dp[x + 1][y] + rices[x] * (n - y + x));
			}
		}
		System.out.println(dp[1][n]);
	}
}
