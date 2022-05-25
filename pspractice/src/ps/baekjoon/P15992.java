package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/05/25 16:10 ~ 16:30 = 20분
public class P15992 {
	long[][] dp = new long[1001][1001];

	public static void main(String[] args) throws IOException {
		P15992 p15992 = new P15992();
		p15992.init();
		p15992.execute();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] s = br.readLine().split(" ");
			System.out.println(p15992.dp[Integer.parseInt(s[0])][Integer.parseInt(s[1])]);
		}
	}

	public void init() {
		dp[1][1] = 1;
		dp[2][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 2;
		dp[3][3] = 1;
	}

	public void execute() {
		for (int i = 4; i < 1001; i++) {
			for (int j = 1; j < 1001; j++) {
				dp[i][j] = i == j ? 1 : (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp[i - 3][j - 1]) % 1_000_000_009;
			}
		}
	}
}
