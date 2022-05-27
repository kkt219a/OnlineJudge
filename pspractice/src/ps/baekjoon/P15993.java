package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/05/27 18:23 ~ 18:34 = 11분
public class P15993 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp = new int[100001][2];
	public static void main(String[] args) throws IOException {
		dp[1][1] = dp[2][0] = dp[2][1] = 1;
		dp[3][0] = dp[3][1] = 2;
		for(int i=4;i<100_001;i++) {
			dp[i][0] = ((dp[i-1][1]+dp[i-2][1])%1_000_000_009+dp[i-3][1])%1_000_000_009;
			dp[i][1] = ((dp[i-1][0]+dp[i-2][0])%1_000_000_009+dp[i-3][0])%1_000_000_009;
		}
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int v = Integer.parseInt(br.readLine());
			System.out.println(dp[v][1]+" "+dp[v][0]);
		}
	}
}
