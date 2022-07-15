package ps.baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 2022/07/14 15:04 ~ 16:04 = 60분
public class P11779 {
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int[][] map;
	static String[] paths;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		dist = new int[n + 1];
		paths = new String[n + 1];
		map = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(map[i], Integer.MAX_VALUE);
		}
		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 0; i < m; i++) {
			int a = read(), b = read(), c = read();
			map[a][b] = Math.min(map[a][b], c);
		}
		int start = read(), end = read();
		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start, 0, "" + start));
		dist[start] = 0;
		paths[start] = ""+start;
		while (!queue.isEmpty()) {
			Node cur = queue.poll(); //0
			System.out.println(cur.paths);
			if (cur.dist > dist[cur.a]) { // 최소 거리가 이미 크다면 통과
				continue;
			}
			for (int i = 0; i <= n; i++) {
				if (map[cur.a][i] != Integer.MAX_VALUE) {
					if (cur.dist + map[cur.a][i] < dist[i]) {
						dist[i] = cur.dist + map[cur.a][i];
						paths[i] = cur.paths + " " + i;
						queue.offer(new Node(i, dist[i], paths[i]));
					}
				}
			}
		}
		System.out.println(dist[end]);
		System.out.println(paths[end].split(" ").length);
		System.out.println(paths[end]);
		System.out.println(Arrays.toString(paths));
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class Node implements Comparable<Node> {
		int a, dist;
		String paths;

		public Node(int a, int dist) {
			this.a = a;
			this.dist = dist;
		}

		public Node(int a, int dist, String paths) {
			this.a = a;
			this.dist = dist;
			this.paths = paths;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dist, o.dist);
		}
	}
}
