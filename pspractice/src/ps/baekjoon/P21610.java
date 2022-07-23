package ps.baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// 2022/07/23 20:13 ~ 20:53 = 40분
public class P21610 {
	// 대각선은 1,3,5,7
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}, dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> rains = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = read();
			}
		}
		init();
		for (int i = 0; i < m; i++) {
			visited = new boolean[n][n];
			int d = read() - 1, s = read();
			for (Point rain : rains) {
				int newX = (rain.x + dx[d] * s) % n, newY = (rain.y + dy[d] * s) % n;
				newX = newX < 0 ? newX + n : newX;
				newY = newY < 0 ? newY + n : newY;
				map[newX][newY]++;
				visited[newX][newY] = true;
			}
			rains.clear();
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (visited[j][k]) {
						for (int p = 1; p <= 7; p += 2) {
							int copyX = j + dx[p], copyY = k + dy[p];
							if (copyX >= 0 && copyY >= 0 && copyX < n && copyY < n && map[copyX][copyY] != 0) {
								map[j][k]++;
							}
						}
					}
				}
			}
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (map[j][k] >= 2 && !visited[j][k]) {
						map[j][k] -= 2;
						rains.add(new Point(j, k));
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cnt += map[i][j];
			}
		}
		System.out.println(cnt);
	}

	private static void init() {
		rains.add(new Point(n - 1, 0));
		rains.add(new Point(n - 1, 1));
		rains.add(new Point(n - 2, 0));
		rains.add(new Point(n - 2, 1));
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
