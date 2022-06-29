package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/29 다시
public class P1238 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, x;
	static List<List<Node>> map = new ArrayList<>(), map2 = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		m = parseIntSt();
		x = parseIntSt();
		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
			map2.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			newToken();
			int a = parseIntSt();
			int b = parseIntSt();
			int c = parseIntSt();
			map.get(a - 1).add(new Node(b - 1, c));
			map2.get(b - 1).add(new Node(a - 1, c));
		}
		int[] dist = dijkstra(map, x-1);
		int[] dist2 = dijkstra(map2, x-1);
		int sum = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			sum = Math.max(dist[i] + dist2[i], sum);
		}
		System.out.println(sum);
	}

	static int[] dijkstra(List<List<Node>> map, int v) {
		int[] dist = new int[n];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[v] = 0;
		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(v, 0));
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			if (dist[now.idx] < now.weight) {
				continue;
			}
			List<Node> nodes = map.get(now.idx);
			for (Node next : nodes) {
				if (next.weight + now.weight < dist[next.idx]) {
					dist[next.idx] = next.weight + now.weight;
					queue.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		return dist;
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static class Node implements Comparable<Node> {
		int idx, weight;

		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
