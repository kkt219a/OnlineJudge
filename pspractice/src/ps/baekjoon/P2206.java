package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/07/17 14:30 ~ 해설참조
public class P2206 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, min = Integer.MAX_VALUE;
	static boolean[][] map;
	static int[][][] dist;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		m = parseIntSt();
		map = new boolean[n][m];
		dist = new int[n][m][2];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) == '0';
			}
		}
		bfs();
		System.out.println(min);
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, 0));
		dist[0][0][0] = 1;
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = poll.x + dx[i], newY = poll.y + dy[i];
				if (newX >= 0 && newY >= 0 && newX < n && newY < m && dist[newX][newY][poll.dest] == 0) {
					if (map[newX][newY]) { // 벽이 아니면
						dist[newX][newY][poll.dest] = dist[poll.x][poll.y][poll.dest] + 1;
						queue.offer(new Point(newX, newY, poll.dest));
					} else if (poll.dest < 1) { // 벽이고 깨야할 만큼 못 깼다면 추가
						dist[newX][newY][poll.dest + 1] = dist[poll.x][poll.y][poll.dest] + 1;
						queue.offer(new Point(newX, newY, poll.dest + 1));
					}
				}
			}
		}
		for (int i : dist[n - 1][m - 1]) {
			if (i != 0) {
				min = Math.min(min, i);
			}
		}
		min = min == Integer.MAX_VALUE ? -1 : min;
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static class Point {
		int x, y, dest;

		public Point(int x, int y, int dest) {
			this.x = x;
			this.y = y;
			this.dest = dest;
		}
	}
}
