package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/04 20:10 ~ 20:40, 해설 참조
public class P1727 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dp = new int[n + 1][m + 1];
		int[] nArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] mArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(nArray);
		Arrays.sort(mArray);
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j - 1] + Math.abs(nArray[i - 1] - mArray[j - 1]);
				if (i < j) {
					dp[i][j] = Math.min(dp[i][j - 1], dp[i][j]);
				} else if (i > j) {
					dp[i][j] = Math.min(dp[i - 1][j], dp[i][j]);
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
