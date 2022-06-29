package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/29 19:48~  20:25 = 37분
public class P14890 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map, map2;
	static int sol, n, l;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		l = parseIntSt();
		map = new int[n][n];
		map2 = new int[n][n];
		for (int i = 0; i < n; i++) {
			newToken();
			for (int j = 0; j < n; j++) {
				map[i][j] = parseIntSt();
				map2[j][i] = map[i][j];
			}
		}
		check(map);
		check(map2);
		System.out.println(sol);
	}

	static void check(int[][] mapParam) {
		for (int i = 0; i < n; i++) {
			// 행 검사
			visited = new boolean[n];
			boolean success = true;
			for (int j = 0; j < n && success; j++) {
				if (j != 0 && mapParam[i][j - 1] < mapParam[i][j]) { // 왼쪽이 낮다면 확인
					for (int k = j - 1; k >= j - l; k--) { //왼쪽에서 l개를 확인할거
						if (!isPossible(i, k, mapParam[i][j], mapParam)) {
							success = false;
							break;
						}
						visited[k] = true;
					}
				}
				if (j != n - 1 && mapParam[i][j + 1] < mapParam[i][j]) {
					for (int k = j + 1; k <= j + l; k++) {
						if (!isPossible(i, k, mapParam[i][j], mapParam)) {
							success = false;
							break;
						}
						visited[k] = true;
					}
				}
			}
			if (success) {
				sol++;
			}
		}
	}

	static boolean isPossible(int i, int k, int highNum, int[][] mapParam) {
		// 범위 안에 있고, 차이가 1이며, 경사로를 놓은 칸이 아니라면 가능하다.
		return k >= 0 && k < n && highNum - mapParam[i][k] == 1 && !visited[k];
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
