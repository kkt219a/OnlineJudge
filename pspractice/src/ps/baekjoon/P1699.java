package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/06/26 02:06 ~ 02:16 = 10분
public class P1699 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dp;

	public static void main(String[] args) throws IOException {
		int n = parseIntBr();
		dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			double s = Math.sqrt(i);
			boolean suc = s - (int)s == 0;
			dp[i] = suc ? 1 : Integer.MAX_VALUE / 5;
			if(!suc) {
				for (int j = (int)Math.sqrt(i); j > 0; j--) {
					dp[i] = Math.min(dp[i], dp[j * j] + dp[i - j * j]);
				}
			}
		}
		System.out.println(dp[n]);
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}
