package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/05/30 19:36 ~ 20:06 해답 참조
public class P14945 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp;
	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		dp = new int[101][101];
		dp[2][1] = 2;
		int sum = 0;
		for(int i=3;i<101;i++) {
			for(int j=1;j<i;j++) {
				dp[i][j] = (dp[i-1][j] * 2 + dp[i-1][j-1] + dp[i-1][j+1]) % 10007;
			}
		}
		for(int i=0;i<n;sum+=dp[n][i++]);
		System.out.println(sum%10007);
	}
}
