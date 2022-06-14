package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/14 12:04 ~ 12:24 = 20분
public class P1647 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<Node> nodes = new PriorityQueue<>();
	static int[] parents;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int max = Integer.MIN_VALUE;
		int ret = 0;
		parents = new int[n+1];
		for(int i=1;i<=n;parents[i]=i,i++);
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodes.offer(new Node(a,b,c));
		}
		while(!nodes.isEmpty()) {
			Node node = nodes.poll();
			if(!union(node.a,node.b)) {
				ret+=node.cost;
				max = Math.max(max,node.cost);
			}
		}
		System.out.println(ret-max);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b) {
			parents[b] = a;
		} else if(a>b) {
			parents[a] = b;
		}
		return a==b;
	}

	private static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	static class Node implements Comparable<Node> {
		int a,b,cost;

		public Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost,o.cost);
		}
	}
}
