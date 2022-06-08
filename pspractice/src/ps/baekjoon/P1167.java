package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 2022/06/08 14:20 ~ 해설 참조
public class P1167 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static List<List<Node>> map = new ArrayList<>();
	static boolean[] visited;
	static int val, maxDist = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<>());
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()), end;
			while ((end = Integer.parseInt(st.nextToken())) != -1) {
				map.get(start).add(new Node(end, Integer.parseInt(st.nextToken())));
			}
		}
		visited = new boolean[n + 1];
		dfs(1, 0);
		visited = new boolean[n + 1];
		maxDist = Integer.MIN_VALUE;
		dfs(val, 0);
		System.out.println(maxDist);
	}

	private static void dfs(int start, int dist) {
		visited[start] = true;
		if (dist > maxDist) {
			val = start;
			maxDist = dist;
		}
		List<Node> nodes = map.get(start);
		for (Node node : nodes) {
			if (node.cost != 0 && !visited[node.idx]) {
				dfs(node.idx, dist + node.cost);
			}
		}
	}

	static class Node {
		int idx;
		int cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
	}
}
