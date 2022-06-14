package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/14 14:10 해설 참조
public class P16202 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Queue<Node> nodes = new PriorityQueue<>();
	static int[] parents;
	static int n;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		parents = new int[n + 1];
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes.offer(new Node(a, b, i));
		}
		boolean f = false;
		for (int i = 0; i < k; i++) {
			int v = kruskal(i, new PriorityQueue<>(nodes));
			if (f) {
				sb.append("0 ");
			} else {
				f = v == 0;
				sb.append(f ? "0" : v).append(" ");
			}
		}
		System.out.println(sb);
	}

	private static int kruskal(int k, Queue<Node> queue) {
		int ret = 0, cnt = 0;
		for (int i = 1; i <= n; parents[i] = i, i++)
			;
		for (; k > 0; k--) {
			queue.poll();
		}
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (!union(node.a, node.b)) {
				ret += node.cost;
				cnt++;
			}
		}
		return cnt == n - 1 ? ret : 0;
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a < b) {
			parents[b] = a;
		} else if (a > b) {
			parents[a] = b;
		}
		return a == b;
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	static class Node implements Comparable<Node> {
		int a, b, cost;

		public Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}
