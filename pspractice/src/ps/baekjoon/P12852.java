package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/05/31 17:23 ~ 17:38 = 15분
public class P12852 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp = new int[1_000_001][3];

	public static void main(String[] args) throws IOException {
		for (int i = 2; i < 1_000_001; i++) {
			dp[i][0] =
				i % 2 == 0 ? Math.min(Math.min(dp[i / 2][0], dp[i / 2][1]), dp[i / 2][2]) + 1 : Integer.MAX_VALUE;
			dp[i][1] =
				i % 3 == 0 ? Math.min(Math.min(dp[i / 3][0], dp[i / 3][1]), dp[i / 3][2]) + 1 : Integer.MAX_VALUE;
			dp[i][2] = Math.min(Math.min(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]) + 1;
		}
		int n = Integer.parseInt(br.readLine());
		System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
		while (n != 0) {
			int min = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
			System.out.print(n + " ");
			n = (dp[n][0] == min) ? n / 2 : ((dp[n][1] == min) ? n / 3 : n - 1);
		}
	}
}
