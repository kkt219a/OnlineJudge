package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/30 15:29 또다른 정답
public class P15684V2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int n, m, h, minV = Integer.MAX_VALUE;
	static boolean stop;

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		m = parseIntSt();
		h = parseIntSt();
		map = new int[h + 1][n + 1];
		for (int i = 0; i < m; i++) {
			newToken();
			int a = parseIntSt();
			int b = parseIntSt();
			map[a][b] = 1;
		}
		for (int i = 0; i <= 3; i++) {
			stop = false;
			dfs(i, 1, 0);
			if (minV != Integer.MAX_VALUE) {
				break;
			}
		}
		System.out.println(minV == Integer.MAX_VALUE ? -1 : minV);
	}

	private static void dfs(int cnt, int x, int depth) {
		if (cnt == depth && isFinished()) {
			minV = Math.min(minV, depth);
			stop = true;
		}
		if (depth < cnt) {
			for (int i = x; i <= h && !stop; i++) {
				for (int j = 1; j < n; j++) {
					if (map[i][j] != 1 && map[i][j - 1] != 1 && map[i][j + 1] != 1) {
						map[i][j] = 1;
						dfs(cnt, i, depth + 1);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	private static boolean isFinished() {
		for (int i = 1; i <= n; i++) {
			int temp = i;
			for (int j = 1; j <= h; j++) {
				if (map[j][temp] == 1) {
					temp++;
				} else if (map[j][temp - 1] == 1) {
					temp--;
				}
			}
			if (temp != i) {
				return false;
			}
		}
		return true;
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
