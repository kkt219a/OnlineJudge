package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/05/31 해설 참고
public class P1937 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static int[][] dp;
	static int[] dx = new int[]{0,0,1,-1};
	static int[] dy = new int[]{1,-1,0,0};
	static int n;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new int[n][n];
		for(int i=0;i<n;i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				ans = Math.max(dfs(i,j),ans);
			}
		}
		System.out.println(ans);
	}

	private static int dfs(int x, int y) {
		if(dp[x][y]!=0) {
			return dp[x][y];
		}
		dp[x][y] = 1;
		for(int i=0;i<4;i++) {
			if(x+dx[i]>=0 && x+dx[i]<n && y+dy[i]>=0 && y+dy[i]<n && map[x+dx[i]][y+dy[i]] > map[x][y]) {
				dp[x][y] = Math.max(dp[x][y], dfs(x + dx[i], y + dy[i])+1);
			}
		}
		return dp[x][y];
	}
}
