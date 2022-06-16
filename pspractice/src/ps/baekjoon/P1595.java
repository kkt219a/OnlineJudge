package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 2022/06/16 14:25 ~ 14:45 = 25분
public class P1595 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<List<Node>> maps = new ArrayList<>();
	static boolean[] visited = new boolean[10001];
	static int maxCost = Integer.MIN_VALUE;
	static int maxIdx = 0;

	public static void main(String[] args) throws IOException {
		for(int i=0;i<10001;i++) {
			maps.add(new ArrayList<>());
		}
		String inp = "";
		int tempVertex = 1;
		while((inp=br.readLine()) != null) {
			st = new StringTokenizer(inp);
			if(!st.hasMoreTokens()) {
				break;
			}
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			maps.get(a).add(new Node(b, cost));
			maps.get(b).add(new Node(a, cost));
			tempVertex = a;
		}
		dfs(tempVertex, 0);
		visited = new boolean[10001];
		dfs(maxIdx, 0);
		System.out.println(maxCost);
	}

	static void dfs(int vertex, int sum) {
		visited[vertex] = true;
		if(maxCost < sum) {
			maxCost = sum;
			maxIdx = vertex;
		}
		for(int i=0;i<maps.get(vertex).size();i++) {
			Node node = maps.get(vertex).get(i);
			if(!visited[node.vertex]) {
				dfs(node.vertex,sum+node.cost);
			}
		}
	}

	static class Node {
		int vertex, cost;
		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
	}
}
