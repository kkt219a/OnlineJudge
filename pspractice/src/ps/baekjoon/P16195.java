package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/06/12 21:05 ~ 21:15 = 10분
public class P16195 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static long[][] dp = new long[1001][1001];

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][3] = 1;
		dp[3][2] = 2;
		for(int i=4;i<1001;i++) {
			dp[i][i] = 1;
			for(int j=1;j<i;j++) {
				dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1])%1_000_000_009;
			}
		}
		for(int i=0;i<t;i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			long sum = 0;
			for(int j=1;j<=m;j++) {
				sum = (sum + dp[n][j])%1_000_000_009;
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
