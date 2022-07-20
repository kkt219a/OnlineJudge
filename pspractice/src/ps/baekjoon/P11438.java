package ps.baekjoon;

import java.util.ArrayList;
import java.util.List;

// 2022/07/20 12:53 ~ 14:26 = 93분
public class P11438 {
	static StringBuilder sb = new StringBuilder();
	static int n, h, m;
	static int[][] parent;
	static int[] d;
	static boolean[] visited;
	static List<List<Integer>> trees = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		n = read();
		h = (int)(Math.log(n) / Math.log(2));
		parent = new int[n + 1][h + 1];
		d = new int[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			trees.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			int a = read(), b = read();
			trees.get(a).add(b);
			trees.get(b).add(a);
		}
		dfs(1, 1);
		fill();
		m = read();
		for (int i = 0; i < m; i++) {
			sb.append(Lca(read(), read())).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int node, int depth) {
		d[node] = depth;
		visited[node] = true;
		List<Integer> children = trees.get(node);
		for (Integer child : children) {
			if (!visited[child]) {
				parent[child][0] = node;
				dfs(child, depth + 1);
			}
		}
	}

	private static void fill() {
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= n; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
	}

	private static int Lca(int a, int b) {
		if (d[a] < d[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int diff = d[a] - d[b];
		for (int i = 0; diff > 0; i++, diff = diff >> 1) {
			if ((diff & 1) == 1) {
				a = parent[a][i];
			}
		}
		if (a == b) {
			return a;
		}
		for (int i = h; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return parent[a][0];
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
