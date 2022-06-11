package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022/06/11 18:20 ~ xx:xx = xx분
public class P9372 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int k = 0; k < t; k++) {
			int n = Integer.parseInt(br.readLine());
			dp = new int[n + 1][n + 1];
			int max = Integer.MIN_VALUE;
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= i; j++) {
					dp[j][i] = dp[j][i - 1] + arr[i - 1];
					max = Math.max(max, dp[j][i]);
				}
			}
			System.out.println(max);
		}
	}
}
