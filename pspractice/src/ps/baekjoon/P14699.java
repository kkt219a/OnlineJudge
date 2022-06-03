package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/03 16:59 ~ 17:28 = 29분
public class P14699 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] height;
	static int[][] dp;
	static boolean[] visited;
	static int n, m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dp = new int[n][n];
		visited = new boolean[n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (height[x - 1] < height[y - 1]) {
				dp[x - 1][y - 1] = 1;
			} else if (height[y - 1] < height[x - 1]) {
				dp[y - 1][x - 1] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(dfs(i));
		}
	}

	private static int dfs(int v) {
		visited[v] = true;
		int maxV = 0;
		for (int i = 0; i < n; i++) {
			if (v != i && !visited[i] && dp[v][i] == 1) {
				dp[v][i] += dfs(i);
			}
			maxV = Math.max(maxV, dp[v][i]);
		}
		visited[v] = false;
		return maxV == 0 ? 1 : maxV;
	}
}
