package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/07/02 14:00 ~ 14:30 = 30분
public class P25330 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k;
	static int[] A, P;
	static boolean[] visited;
	static int maxV = 0;

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		k = parseIntSt();
		A = new int[n];
		P = new int[n];
		visited = new boolean[n];
		newToken();
		for (int i = 0; i < n; i++) {
			A[i] = parseIntSt();
		}
		newToken();
		for (int i = 0; i < n; i++) {
			P[i] = parseIntSt();
		}
		dfs( 0, k, 0);
		System.out.println(maxV);
	}

	private static void dfs(int sum, int leaveK, int p) {
		if (leaveK >= 0) {
			maxV = Math.max(maxV, p);
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(sum + A[i], leaveK - sum - A[i], P[i] + p);
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
