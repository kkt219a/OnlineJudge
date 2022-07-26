package ps.baekjoon;

import java.util.ArrayList;
import java.util.List;

// 2022/07/26 2시간
public class P21611 {
	static int n, m, center;
	static int[][] map;
	static boolean[][] visited;
	// 상하좌우
	// 좌하우상
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0}, number = new int[4];

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		center = n / 2;
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = read();
			}
		}
		for (int p = 0; p < m; p++) {
			int d = read(), s = read();
			d = d == 1 ? 3 : (d == 2 ? 1 : (d == 3 ? 0 : 2));
			// 구슬파괴
			for (int j = 1; j <= s; j++) {
				int newX = center + dx[d] * j, newY = center + dy[d] * j;
				map[newX][newY] = 0;
			}
			List<Integer> points = new ArrayList<>();
			List<Integer> tmp = new ArrayList<>();
			int x = center, y = center, dir = 0;
			visited = new boolean[n][n];
			while (!(x == 0 && y == 0)) {
				visited[x][y] = true;
				x += dx[dir];
				y += dy[dir];
				if (map[x][y] != 0) {
					points.add(map[x][y]);
				}
				if (isChanged(x, y, dir)) {
					dir = (dir + 1) % 4;
				}
			}
			boolean rem = true;
			int prev, len;
			while (rem) {
				prev = -1;
				len = 0;
				rem = false;
				for (Integer point : points) {
					if (prev != point) { // 수가 달라졌다면
						if (len > 3) { // 같은 수가 3회 이상 반복됐다면 삭제
							while (!tmp.isEmpty() && len > 0) {
								number[tmp.remove(tmp.size() - 1)]++;
								len--;
								rem = true;
							}
						}
						len = 0;
					}
					prev = point;
					tmp.add(point);
					len++;
				}
				if (len > 3) { // 같은 수가 3회 이상 반복됐다면 삭제
					while (!tmp.isEmpty() && len > 0) {
						number[tmp.remove(tmp.size() - 1)]++;
						len--;
					}
				}
				points = new ArrayList<>(tmp);
				tmp.clear();
			}
			prev = -1;
			len = 1;
			for (Integer point : points) {
				if (prev == point) {
					len++;
				} else if (prev != -1) {
					tmp.add(len);
					tmp.add(prev);
					len = 1;
				}
				prev = point;
			}
			if (!points.isEmpty()) {
				tmp.add(len);
				tmp.add(prev);
			}
			x = center;
			y = center;
			dir = 0;
			int cnt = 0;
			visited = new boolean[n][n];
			while (!(x == 0 && y == 0)) {
				visited[x][y] = true;
				x += dx[dir];
				y += dy[dir];
				if (tmp.size() > cnt) {
					map[x][y] = tmp.get(cnt++);
				} else {
					map[x][y] = 0;
				}
				if (isChanged(x, y, dir)) {
					dir = (dir + 1) % 4;
				}
			}
		}
		System.out.println(number[1] + 2 * number[2] + 3 * number[3]);
	}

	private static boolean isChanged(int x, int y, int dir) {
		return !visited[x + dx[(dir + 1) % 4]][y + dy[(dir + 1) % 4]];
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
