package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/06/17 다시
public class P2156 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp = new int[10001][3];

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			int v = Integer.parseInt(br.readLine());
			dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
			dp[i][1] = dp[i - 1][0] + v;
			dp[i][2] = dp[i - 1][1] + v;
		}
		System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
	}
}
