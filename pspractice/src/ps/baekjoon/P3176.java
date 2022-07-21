package ps.baekjoon;

import java.util.ArrayList;
import java.util.List;

// 2022/07/21 14:13 ~ xx:xx = xx분
public class P3176 {
	static StringBuilder sb = new StringBuilder();
	static List<List<Node>> trees = new ArrayList<>();
	static int n, m, h;
	static boolean[] visited;
	static int[] dep;
	static int[][] parent, distMax, distMin;

	public static void main(String[] args) throws Exception {
		n = read();
		visited = new boolean[n + 1];
		dep = new int[n + 1];
		h = (int)(Math.log(n) / Math.log(2));
		parent = new int[n + 1][h + 1];
		distMax = new int[n + 1][h + 1];
		distMin = new int[n + 1][h + 1];
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
			lca(a, b);
		}
		System.out.println(sb);
	}

	private static void lca(int a, int b) {
		if (dep[a] < dep[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int min = Integer.MAX_VALUE, max = 0;
		int oA = a, oB = b;
		for (int i = 0, j = dep[a] - dep[b]; j > 0; j >>= 1, i++) {
			if ((j & 1) == 1) {
				min = Math.min(min, distMin[a][i]);
				max = Math.max(max, distMax[a][i]);
				a = parent[a][i];
			}
		}
		if (a == b) {
			sb.append(min).append(" ").append(max).append("\n");
		} else {
			for (int i = h; i >= 0; i--) {
				if (parent[a][i] != parent[b][i]) {
					min = Math.min(Math.min(min, distMin[a][i]), distMin[b][i]);
					max = Math.max(Math.max(max, distMax[a][i]), distMax[b][i]);
					a = parent[a][i];
					b = parent[b][i];
				}
			}
			sb.append(Math.min(min, Math.min(distMin[a][0], distMin[b][0])))
				.append(" ")
				.append(Math.max(max, Math.max(distMax[a][0], distMax[b][0])))
				.append("\n");
		}
	}

	private static void fill() {
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= n; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
				distMin[j][i] = Math.min(distMin[j][i - 1], distMin[parent[j][i - 1]][i - 1]);
				distMax[j][i] = Math.max(distMax[j][i - 1], distMax[parent[j][i - 1]][i - 1]);
			}
		}
	}

	private static void dfs(int num, int depth, int dis) {
		visited[num] = true;
		dep[num] = depth;
		List<Node> nodes = trees.get(num);
		for (Node node : nodes) {
			if (!visited[node.num]) {
				parent[node.num][0] = num;
				distMax[node.num][0] = node.dist;
				distMin[node.num][0] = node.dist;
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
