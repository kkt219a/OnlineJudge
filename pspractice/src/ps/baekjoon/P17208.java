package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/24 22:28 ~ 23:28 = 60분
public class P17208 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, k;
	static int[] ch, po;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		ch = new int[n];
		po = new int[n];
		dp = new int[m + 1][k + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ch[i] = Integer.parseInt(st.nextToken());
			po[i] = Integer.parseInt(st.nextToken());
		}
		// dp[0][0] = 1;
		for (int a = 0; a < n; a++) {
			for (int i = m; i >= 1; i--) {
				for (int j = k; j >= 1; j--) {
					if (i >= ch[a] && j >= po[a]) {
						dp[i][j] = Math.max(dp[i - ch[a]][j - po[a]] + 1, dp[i][j]);
					}
				}
			}
			for (int[] ints : dp) {
				System.out.println(Arrays.toString(ints));
			}
			System.out.println();
		}
		System.out.println(dp[m][k]);
	}
}
