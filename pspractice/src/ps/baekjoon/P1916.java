package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1916 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<List<Node>> map = new ArrayList<>();
	static int[] cost;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<=n;i++) {
			map.add(new ArrayList<>());
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map.get(a).add(new Node(b,cost));
		}
		cost = new int[n+1];
		for(int i=0;i<=n;i++) {
			cost[i] = Integer.MAX_VALUE;
		}

		String[] s = br.readLine().split(" ");
		int start = Integer.parseInt(s[0]);
		int end = Integer.parseInt(s[1]);

		Queue<Node> queue = new PriorityQueue<>();
		queue.offer(new Node(start,0)); // 시작지점 설정
		cost[start] = 0; // 시작지점 비용 0 초기화
		while(!queue.isEmpty()) {
			Node poll = queue.poll(); // 비용이 가장 적은 지점 방문
			// 시작점에서 해당 인덱스까지 최소 비용이, 현재 지점보다 작다면 통과
			if(cost[poll.idx] < poll.weight) {
				continue;
			}
			// 방문한 지점과 연결된 모든 간선 탐색
			for(int i=0;i<map.get(poll.idx).size();i++) {
				Node node = map.get(poll.idx).get(i);
				// 방문한 지점과, 연결된 지점의 합 비용이 최소비용보다 적다면
				if(node.weight + poll.weight < cost[node.idx]) {
					// 방문한 지점까지 비용과 연결된 지점의 비용의 합으로 초기화
					cost[node.idx] = node.weight + poll.weight;
					queue.offer(new Node(node.idx, cost[node.idx]));
				}
			}
		}
		System.out.println(cost[end]);
	}

	static class Node implements Comparable<Node> {
		int idx;
		int weight;

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
