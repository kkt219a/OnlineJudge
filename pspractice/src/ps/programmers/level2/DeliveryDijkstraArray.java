package ps.programmers.level2;

import java.util.PriorityQueue;
import java.util.Queue;

// Summer/Winter Coding(~2018) - 배달
// 2022/04/12 00:30~
public class DeliveryDijkstraArray {
	static final int MAX_WEIGHT = 500_001;
	int[][] map;
	int[] dist;
	boolean[] visited;
	public int solution(int N, int[][] road, int K) {
		init(N);
		for (int[] roadArr : road) {
			setMap(roadArr[0],roadArr[1],roadArr[2]);
		}
		dijkstra(0);
		return getAnswer(K);
	}

	private int getAnswer(int k) {
		int answer = 0;
		for (int j : dist) {
			if (j <= k) {
				answer++;
			}
		}
		return answer;
	}

	private void dijkstra(int start) {
		Queue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start,0));
		dist[start] = 0;
		while(!queue.isEmpty()) {
			Node poll = queue.poll();
			visited[poll.idx] = true;
			if(dist[poll.idx]< poll.weight) continue;
			for(int i=0;i<map.length;i++) {
				if(!visited[i]&&map[poll.idx][i]!=MAX_WEIGHT&&poll.weight+map[poll.idx][i] < dist[i]) {
					queue.add(new Node(i, poll.weight+map[poll.idx][i]));
					dist[i] = dist[poll.idx]+map[poll.idx][i];
				}
			}
		}
	}

	private void init(int n) {
		map = new int[n][n];
		visited = new boolean[n];
		dist = new int[n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = i==j ? 0 : MAX_WEIGHT;
			}
			dist[i] = MAX_WEIGHT;
		}
	}

	private void setMap(int start, int end, int weight) {
		map[start-1][end-1] = Integer.min(weight,map[start-1][end-1]);
		map[end-1][start-1] = Integer.min(weight,map[end-1][start-1]);
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
