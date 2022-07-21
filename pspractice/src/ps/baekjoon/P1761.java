package ps.baekjoon;

import java.util.ArrayList;
import java.util.List;

// 2022/07/21 14:13 ~ xx:xx = xx분
public class P1761 {
	static StringBuilder sb = new StringBuilder();
	static List<List<Node>> trees = new ArrayList<>();
	static int n, m, h;
	static boolean[] visited;
	static int[] dep, dist;
	static int[][] parent;

	public static void main(String[] args) throws Exception {
		n = read();
		visited = new boolean[n + 1];
		dep = new int[n + 1];
		h = (int)(Math.log(n) / Math.log(2));
		parent = new int[n + 1][h + 1];
		dist = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			trees.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			int a = read(), b = read(), c = read();
			trees.get(a).add(new Node(b, c));
			trees.get(b).add(new Node(a, c));
		}
		dfs(1, 1, 0);
		fill();
		m = read();
		for (int i = 0; i < m; i++) {
			int a = read(), b = read();
			sb.append(lca(a, b)).append("\n");
		}
		System.out.println(sb);
	}

	private static int lca(int a, int b) {
		int cost = 0;
		if (dep[a] < dep[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int oA = a, oB = b;
		for (int i = 0, j = dep[a] - dep[b]; j > 0; j >>= 1, i++) {
			if ((j & 1) == 1) {
				a = parent[a][i];
			}
		}
		if (a == b) {
			return dist[oA] - dist[oB];
		}
		for (int i = h; i >= 0; i--) {
			if (parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return dist[oA] + dist[oB] - dist[parent[a][0]] * 2;
	}

	private static void fill() {
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= n; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
	}

	private static void dfs(int num, int depth, int dis) {
		visited[num] = true;
		dep[num] = depth;
		dist[num] = dis;
		List<Node> nodes = trees.get(num);
		for (Node node : nodes) {
			if (!visited[node.num]) {
				parent[node.num][0] = num;
				dfs(node.num, depth + 1, dis + node.dist);
			}
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class Node {
		int num;
		int dist;

		public Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
}
