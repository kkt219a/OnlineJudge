package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/26 16:22 ~ 17:00 = 38분
public class P17404 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr, dp;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		int n = parseIntBr();
		arr = new int[n + 1][3];
		for (int i = 1; i <= n; i++) {
			newToken();
			arr[i][0] = parseIntSt();
			arr[i][1] = parseIntSt();
			arr[i][2] = parseIntSt();
		}
		for (int i = 0; i < 3; i++) {
			dp = new int[n + 1][3];
			for (int j = 0; j < 3; j++) {
				dp[1][j] = i != j ? 100_001 : arr[1][j];
			}
			for (int j = 2; j <= n; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + arr[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + arr[j][1];
				dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + arr[j][2];
			}
			for (int j = 0; j < 3; j++) {
				if (i != j) {
					min = Math.min(min, dp[n][j]);
				}
			}
		}
		System.out.println(min);
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
