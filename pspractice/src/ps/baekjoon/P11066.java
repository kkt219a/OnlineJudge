package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/30 해설 참조
public class P11066 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] arr, sum;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		int t = parseIntBr();
		while (t-- > 0) {
			int n = parseIntBr();
			newToken();
			arr = new int[n + 1];
			sum = new int[n + 1];
			dp = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = parseIntSt();
				sum[i] = sum[i - 1] + arr[i];
			}
			for (int i = 1; i < n; i++) {
				for (int j = 1; j <= n - i; j++) {
					dp[j][j + i] = Integer.MAX_VALUE;
					for (int k = j; k < j + i; k++) {
						dp[j][j + i] = Math.min(dp[j][k] + dp[k + 1][j + i], dp[j][j + i]);
					}
					dp[j][j + i] += sum[j + i] - sum[j - 1];
				}
			}
			sb.append(dp[1][n]).append("\n");
		}
		System.out.println(sb);
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
