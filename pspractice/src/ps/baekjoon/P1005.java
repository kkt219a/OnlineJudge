package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/29 16:55 ~ 17:30, 솔루션
public class P1005 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static List<List<Integer>> arr = new ArrayList<>();
	static int[] inDegree;
	static int[] times;

	public static void main(String[] args) throws IOException {
		int t = parseIntBr();
		for (; t > 0; t--) {
			newToken();
			int n = parseIntSt();
			int k = parseIntSt();
			arr = new ArrayList<>();
			inDegree = new int[n + 1];
			times = new int[n + 1];
			newToken();
			for (int i = 0; i <= n; i++) {
				arr.add(new ArrayList<>());
				if (i != 0) {
					times[i] = parseIntSt();
				}
			}
			for (int i = 0; i < k; i++) {
				newToken();
				int a = parseIntSt();
				int b = parseIntSt();
				arr.get(a).add(b);
				inDegree[b]++;
			}
			int w = parseIntBr();
			Queue<Node> queue = new PriorityQueue<>();
			for (int i = 1; i <= n; i++) {
				if (inDegree[i] == 0) {
					queue.add(new Node(i, times[i]));
				}
			}
			int totalTime = 0;
			while (!queue.isEmpty()) {
				Node now = queue.poll();
				totalTime = now.time;
				if (now.idx == w) {
					break;
				}
				List<Integer> nodes = arr.get(now.idx);
				for (Integer node : nodes) {
					inDegree[node]--;
					if (inDegree[node] == 0) {
						queue.offer(new Node(node, now.time + times[node]));
					}
				}
			}
			sb.append(totalTime).append("\n");
		}
		System.out.println(sb);
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static class Node implements Comparable<Node> {
		int idx, time;

		public Node(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time,o.time);
		}
	}
}
