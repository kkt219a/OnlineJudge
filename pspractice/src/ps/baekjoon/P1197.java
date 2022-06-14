package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 2022/06/14 11:02 ~ 11:17 = 15분
public class P1197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parents;
	static List<Node> nodes = new ArrayList<>();
	static int ret;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parents = new int[v+1];
		for(int i = 1; i<=v; parents[i]=i,i++);
		for(int i=0;i<e;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			nodes.add(new Node(a,b,cost));
		}
		Collections.sort(nodes);
		for (Node node : nodes) {
			if (find(node.a) != find(node.b)) {
				union(node.a, node.b);
				ret += node.cost;
			}
		}
		System.out.println(ret);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}

	private static int find(int a) {
		if(parents[a]!=a) {
			return parents[a] = find(parents[a]);
		} else {
			return parents[a];
		}
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
