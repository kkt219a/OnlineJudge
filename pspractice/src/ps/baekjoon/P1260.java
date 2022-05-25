package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/05/25 22:16 ~ 22:34 = 18분
public class P1260 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		String[] o = br.readLine().split(" ");
		map = new int[Integer.parseInt(o[0])+1][Integer.parseInt(o[0])+1];
		visited = new boolean[Integer.parseInt(o[0])+1];
		for(int i=0, j=Integer.parseInt(o[1]);i<j;i++) {
			String[] o2 = br.readLine().split(" ");
			map[Integer.parseInt(o2[0])][Integer.parseInt(o2[1])] = 1;
			map[Integer.parseInt(o2[1])][Integer.parseInt(o2[0])] = 1;
		}
		dfs(Integer.parseInt(o[2]));
		System.out.println();
		visited = new boolean[Integer.parseInt(o[0])+1];
		bfs(Integer.parseInt(o[2]));
	}

	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		System.out.print(start+" ");
		while(!queue.isEmpty()) {
			Integer poll = queue.poll();
			for(int i=0;i<map.length;i++) {
				if (!visited[i] && map[poll][i] != 0) {
					System.out.print(i+" ");
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}

	private static void dfs(int start) {
		visited[start] = true;
		System.out.print(start+" ");
		for(int i=0;i<map.length;i++) {
			if(!visited[i]&&map[start][i] != 0) {
				dfs(i);
			}
		}
	}
}
