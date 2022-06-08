package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/08 11:46 ~ 12:30 TLE 참조
public class P7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static int[][] map;
	static int[][] days;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		days = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				days[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					queue.offer(new Point(i, j, 0));
				}
			}
		}
		bfs();
		int maxDay = Integer.MIN_VALUE;
		// 0이 하나라도 있거나, maxDay가 1이거나
		boolean success = true;
		for (int i = 0; i < n && success; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != -1) {
					if (map[i][j] == 0) {
						success = false;
						break;
					}
					maxDay = Math.max(maxDay, map[i][j]);
				}
			}
		}
		System.out.println(!success ? -1 : maxDay == 1 ? 0 : maxDay);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = poll.x + dx[i];
				int newY = poll.y + dy[i];
				int newDay = poll.day + 1;
				if (newX >= 0 && newX < n && newY >= 0 && newY < m && map[newX][newY] == 0) {
					queue.offer(new Point(newX, newY, newDay));
					map[newX][newY] = newDay;
				}
			}
		}
	}

	static class Point {
		int x;
		int y;
		int day;

		public Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}
