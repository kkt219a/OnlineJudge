package ps.baekjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

// 2022/07/12 18:05 ~ 19:10 = 65분
public class P17135 {
	static boolean[][] map;
	static int n, m, d, ret = -1;
	static List<Integer> archers = new ArrayList<>();
	static boolean[] visited;
	static int[] dx = {0, -1, 0}, dy = {-1, 0, 1};

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		d = read();
		map = new boolean[n][m];
		visited = new boolean[m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = read() == 1;
			}
		}
		dfs(-1);
		System.out.println(ret);
	}

	private static void dfs(int start) {
		if (archers.size() == 3) {
			ret = Math.max(ret, gameStart());
		} else {
			for (int i = start + 1; i < m; i++) {
				if (!visited[i]) {
					visited[i] = true;
					archers.add(i);
					dfs(i);
					archers.remove(Integer.valueOf(i));
					visited[i] = false;
				}
			}
		}
	}

	private static int gameStart() {
		boolean[][] tempMap = new boolean[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, tempMap[i], 0, m);
		}
		for (int x = n; x > 0; x--) {
			Set<java.awt.Point> set = new HashSet<>();
			for (Integer archer : archers) {
				Optional<Point> oPoint = bfs(x - 1, archer, tempMap);
				if (oPoint.isPresent()) {
					Point point = oPoint.get();
					set.add(new java.awt.Point(point.x, point.y));
				}
			}
			for (java.awt.Point point : set) {
				tempMap[point.x][point.y] = false;
			}
			cnt += set.size();
		}
		return cnt;
	}

	private static Optional<Point> bfs(int x, int y, boolean[][] tempMap) {
		boolean[][] tempVisited = new boolean[n][m];
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y, 1));
		tempVisited[x][y] = true;
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			if (tempMap[poll.x][poll.y]) {
				return Optional.of(poll);
			} else {
				for (int i = 0; i < 3; i++) {
					int newX = poll.x + dx[i], newY = poll.y + dy[i];
					if (newX >= 0 && newY >= 0 && newX < n && newY < m && poll.d < d && !tempVisited[newX][newY]) {
						queue.offer(new Point(newX, newY, poll.d + 1));
						tempVisited[newX][newY] = true;
					}
				}
			}
		}
		return Optional.empty();
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class Point {
		int x, y, d;

		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
