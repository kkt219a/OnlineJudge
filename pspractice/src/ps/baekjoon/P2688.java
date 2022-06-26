package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/06/26 01:47 ~ 02:03 = 16분
public class P2688 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static long[][] dp = new long[65][10];

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i < 65; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					dp[i][j] += dp[i - 1][k];
				}
			}
		}
		int t = parseIntBr();
		for (; t != 0; t--) {
			int n = parseIntBr();
			long sum = 0;
			for (int i = 0; i < 10; i++) {
				sum += dp[n][i];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}
}
