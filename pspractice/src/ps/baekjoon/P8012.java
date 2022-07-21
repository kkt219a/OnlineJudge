package ps.baekjoon;

import java.util.ArrayList;
import java.util.List;

// 2022/0x/xx xx:xx ~ xx:xx = xx분
public class P8012 {
	static int n, m,h;
	static int[][] parent;
	static int[] dists, depth;
	static boolean[] visited;
	static List<List<Node>> trees = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		n = read();
		h = (int)(Math.log(n)/Math.log(2));
		dists = new int[n+1];
		parent = new int[n+1][h+1];
		depth = new int[n+1];
		visited = new boolean[n+1];
		for(int i=0;i<=n;i++) {
			trees.add(new ArrayList<>());
		}
		for(int i=0;i<n-1;i++) {
			int a = read(), b= read();
			trees.get(a).add(new Node(b, 1));
			trees.get(b).add(new Node(a, 1));
		}
		dfs(1,1,0);
		fill();
		int prev = 1;
		int cnt=0;
		m = read();
		for(int i=0;i<m;i++) {
			int cur = read();
			cnt += lca(prev, cur);
			prev = cur;
		}
		System.out.println(cnt);
	}

	private static int lca(int a, int b) {
		if(depth[a]<depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int oA = a, oB = b;
		for(int i=0,j=depth[a]-depth[b];j>0;i++, j>>=1) {
			if((j&1) == 1) {
				a = parent[a][i];
			}
		}
		if(a==b) {
			return dists[oA]-dists[oB];
		}
		for(int i=h;i>=0;i--) {
			if(parent[a][i] != parent[b][i]) {
				a = parent[a][i];
				b = parent[b][i];
			}
		}
		return dists[oA] + dists[oB] - dists[parent[a][0]] * 2;
	}

	private static void fill() {
		for(int i=1;i<=h;i++) {
			for(int j=1;j<=n;j++) {
				parent[j][i] = parent[parent[j][i-1]][i-1];
			}
		}
	}

	private static void dfs(int num, int d, int dist) {
		depth[num] = d;
		dists[num] = dist;
		visited[num] = true;
		List<Node> nodes = trees.get(num);
		for (Node node : nodes) {
			if(!visited[node.num]) {
				parent[node.num][0] = num;
				dfs(node.num, d + 1, dist + node.dist);
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
