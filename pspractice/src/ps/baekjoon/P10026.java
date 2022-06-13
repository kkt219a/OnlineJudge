package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 2022/06/13 11:34 ~ 11:55 = 21분
public class P10026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new char[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			char[] chars = br.readLine().toCharArray();
			if (n >= 0)
				System.arraycopy(chars, 0, map[i], 1, n);
		}
		System.out.println(search(false) + " " + search(true));

	}

	public static int search(boolean d) {
		visited = new boolean[n + 1][n + 1];
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (!visited[i][j]) {
					bfs(d, i, j, map[i][j]);
					sum++;
				}
			}
		}
		return sum;
	}

	public static void bfs(boolean d, int x, int y, char color) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				if (poll.x + dx[i] >= 0 && poll.y + dy[i] >= 0 && poll.x + dx[i] <= n && poll.y + dy[i] <= n
					&& !visited[poll.x + dx[i]][poll.y + dy[i]] &&
					check(map[poll.x + dx[i]][poll.y + dy[i]], color, d)) {
					visited[poll.x + dx[i]][poll.y + dy[i]] = true;
					queue.offer(new Point(poll.x + dx[i], poll.y + dy[i]));
				}
			}
		}
	}

	private static boolean check(char c, char color, boolean d) {
		if (c == color) {
			return true;
		} else {
			return d && ((c == 'R' && color == 'G') || (c == 'G' && color == 'R'));
		}
	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
