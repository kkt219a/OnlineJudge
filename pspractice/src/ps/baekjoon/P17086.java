package ps.baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;

// 2022/08/06 18:10 ~ 18:29 = 19분
public class P17086 {
	static int n, m, max = -1;
	static boolean[][] map, visited;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		map = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = read() == 1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!map[i][j]) {
					visited = new boolean[n][m];
					bfs(i, j);
				}
			}
		}
		System.out.println(max);
	}

	private static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x, y, 0));
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			if (poll.cnt >= min) {
				continue;
			}
			if (map[poll.x][poll.y] && !(poll.x == x && poll.y == y)) {
				min = poll.cnt;
				continue;
			}
			for (int i = 0; i < 8; i++) {
				int newX = poll.x + dx[i], newY = poll.y + dy[i];
				if (newX >= 0 && newY >= 0 && newX < n && newY < m && !visited[newX][newY]) {
					visited[newX][newY] = true;
					queue.offer(new Point(newX, newY, poll.cnt + 1));
				}
			}
		}
		max = Math.max(max, min);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
