package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 2022/06/02 12:43 ~ 12:53 = 10분
public class P5568 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Set<Integer> set = new HashSet<>();
	static int[] arr;
	static boolean[] visited;
	static int k;
	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		visited = new boolean[n];
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0, "");
		System.out.println(set.size());
	}

	private static void dfs(int depth, String col) {
		if (depth == k) {
			set.add(Integer.parseInt(col));
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(depth + 1, col + arr[i]);
					visited[i] = false;
				}
			}
		}
	}
}
