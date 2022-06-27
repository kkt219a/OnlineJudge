package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 2022/06/27 17:06 ~ 17:26 = 20분
public class P16439 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr;
	static boolean[] visited;
	static int n, m, sum = Integer.MIN_VALUE;
	static List<Integer> paths = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		m = parseIntSt();
		arr = new int[n][m];
		visited = new boolean[m];
		for (int i = 0; i < n; i++) {
			newToken();
			for (int j = 0; j < m; j++) {
				arr[i][j] = parseIntSt();
			}
		}
		dfs(0);
		System.out.println(sum);
	}

	static void dfs(int start) {
		if (paths.size() == 3) {
			int tempSum = 0;
			for (int i = 0; i < n; i++) {
				int tmp = 0;
				for (Integer path : paths) {
					tmp = Math.max(tmp, arr[i][path]);
				}
				tempSum += tmp;
			}
			sum = Math.max(tempSum, sum);
		} else {
			for (int i = start; i < m; i++) {
				if (!visited[i]) {
					visited[i] = true;
					paths.add(i);
					dfs(i + 1);
					paths.remove(Integer.valueOf(i));
					visited[i] = false;
				}
			}
		}
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
