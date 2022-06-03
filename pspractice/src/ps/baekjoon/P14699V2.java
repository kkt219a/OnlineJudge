package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최적화
public class P14699V2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] height;
	static boolean[][] connected;
	static int[] dp;
	static int n, m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		connected = new boolean[n][n];
		dp = new int[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (height[x - 1] < height[y - 1]) {
				connected[x - 1][y - 1] = true;
			} else if (height[y - 1] < height[x - 1]) {
				connected[y - 1][x - 1] = true;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(dfs(i));
		}
	}

	private static int dfs(int v) {
		if(dp[v] != 0) {
			return dp[v];
		}
		dp[v] = 1;
		for (int i = 0; i < n; i++) {
			if (connected[v][i]) {
				dp[v] = Math.max(dp[v], dfs(i)+1);
			}
		}
		return dp[v];
	}
}
