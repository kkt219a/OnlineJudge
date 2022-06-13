package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/06/14 해설 참조
public class P15991 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static long[] dp = new long[100001];

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		dp[1] = 1;
		dp[2] = dp[3] = 2;
		dp[4] = dp[5] = 3;
		dp[6] = 6;
		for (int i = 7; i < 100001; i++) {
			dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1_000_000_009;
		}
		for (int i = 0; i < t; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		System.out.println(sb);
	}
}
