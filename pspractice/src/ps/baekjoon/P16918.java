package ps.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/08/08 14:51 ~ 15:23 = 32분
public class P16918 {
	static int r, c, n;
	static int[] dx = {0, 0, 1, 0, -1}, dy = {0, 1, 0, -1, 0};
	static char[][] map;
	static boolean[][] visited;
	static int[][] boomTime;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		newToken();
		r = parseIntSt();
		c = parseIntSt();
		n = parseIntSt();
		map = new char[r][c];
		boomTime = new int[r][c];
		for (int i = 0; i < r; i++) {
			String s = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'O') {
					boomTime[i][j] = 2;
				}
			}
		}
		int time = 1;
		while (time < n) {
			visited = new boolean[r][c];
			int now = time % 2;
			if (now == 1) {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (map[i][j] == '.') {
							map[i][j] = 'O';
							boomTime[i][j] = time + 3;
						}
					}
				}
			} else {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (map[i][j] == 'O' && boomTime[i][j] == time) {
							for (int k = 0; k < 5; k++) {
								int newX = i + dx[k], newY = j + dy[k];
								if (newX >= 0 && newY >= 0 && newX < r && newY < c) {
									visited[newX][newY] = true;
								}
							}
						}
					}
				}
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (visited[i][j]) {
							map[i][j] = '.';
							boomTime[i][j] = 0;
						}
					}
				}
			}
			time++;
		}
		for (char[] chars : map) {
			for (char aChar : chars) {
				sb.append(aChar);
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws Exception {
		st = new StringTokenizer(br.readLine());
	}

}
