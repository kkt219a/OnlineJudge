package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/30 1트: 60~80분
public class P15684 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int n, m, h, minV = Integer.MAX_VALUE;

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
		dfs(1, 1, 0);
		System.out.println(minV == Integer.MAX_VALUE ? -1 : minV);
	}

	private static void dfs(int x, int y, int depth) {
		boolean success = true;
		for (int i = 1; i <= n; i++) {
			int temp = i; // 출발 노드
			for (int j = 1; j <= h; j++) {
				if (map[j][temp] == 1) { // 우측 사다리 점검
					temp++;
				} else if (map[j][temp - 1] == 1) { // 좌측 사다리 점검
					temp--;
				}
			}
			if (temp != i) { // 하나라도 통과 안하면 중단
				success = false;
				break;
			}
		}
		if (success) {
			minV = Math.min(minV, depth);
		} else if (depth < 3 && depth < minV) {
			for (int i = x; i <= h; i++) {
				for (int j = 1; j < n; j++) {
					// 가로선은 앞 뒤에 가로선이 있다면 놓을 수 없어서 가지치기
					if (map[i][j] != 1 && map[i][j - 1] != 1 && map[i][j + 1] != 1) {
						map[i][j] = 1;
						dfs(i, j, depth + 1);
						map[i][j] = 0; // 다른 백트래킹을 위해서 방문상태 초기화
					}
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
