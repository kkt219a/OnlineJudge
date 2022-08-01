package ps.baekjoon;

import java.util.ArrayList;
import java.util.List;

// 2022/08/01 해설 참조
public class P2533 {
	static int n;
	static List<List<Integer>> g = new ArrayList<>();
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		n = read();
		dp = new int[n+1][2];
		for(int i=0;i<=n;i++) {
			g.add(new ArrayList<>());
		}
		for(int i=0;i<n-1;i++) {
			int a= read(), b = read();
			g.get(a).add(b);
			g.get(b).add(a);
		}
		dfs(1, -1);
		System.out.println(Math.min(dp[1][0],dp[1][1]));
	}

	private static void dfs(int i, int j) {
		dp[i][0] = 1;
		dp[i][1] = 0;
		List<Integer> list = g.get(i);
		for (Integer v : list) {
			if(j!=v) {
				dfs(v, i);
				dp[i][1] += dp[v][0];
				dp[i][0] += Math.min(dp[v][0], dp[v][1]);
			}
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
