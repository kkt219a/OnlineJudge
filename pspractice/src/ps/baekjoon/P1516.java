package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/16 다시
public class P1516 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static List<List<Integer>> maps = new ArrayList<>();
	static int[] inDegrees;
	static int[] times;
	static int[] results;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		inDegrees = new int[n + 1];
		times = new int[n + 1];
		results = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			maps.add(new ArrayList<>());
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			int vertex;
			while ((vertex = Integer.parseInt(st.nextToken())) != -1) {
				inDegrees[i]++;
				maps.get(vertex).add(i);
			}
		}
		bfs(n);
		for (int i = 1; i <= n; sb.append(results[i++]).append("\n"))
			;
		System.out.println(sb);
	}

	private static void bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			results[i] = times[i];
			if (inDegrees[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			for (int i = 0; i < maps.get(poll).size(); i++) {
				Integer idx = maps.get(poll).get(i);
				results[idx] = Math.max(results[idx], results[poll] + times[idx]);
				inDegrees[idx]--;
				if (inDegrees[idx] == 0) {
					queue.offer(idx);
				}
			}
		}
	}
}
