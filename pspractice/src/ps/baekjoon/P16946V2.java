package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/07/17 30분
public class P16946V2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, min = Integer.MAX_VALUE, k;
	static boolean[][] map;
	static boolean[][][] visited;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		m = parseIntSt();
		k = parseIntSt();
		map = new boolean[n][m];
		visited = new boolean[n][m][k+1];
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
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(0, 0, 0, 0, 1));
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			if(poll.x == n-1 && poll.y == m-1) {
				min = poll.len;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int newX = poll.x + dx[i], newY = poll.y + dy[i];
				if (newX >= 0 && newY >= 0 && newX < n && newY < m) {
					if (map[newX][newY] && !visited[newX][newY][poll.dest]) {
						queue.offer(new Point(newX, newY, poll.dest, (poll.day+1)%2, poll.len+1));
						visited[newX][newY][poll.dest] = true;
					} else if (poll.dest < k) {
						if(poll.day==0 && !visited[newX][newY][poll.dest+1]) {
							visited[newX][newY][poll.dest+1] = true;
							queue.offer(new Point(newX, newY, poll.dest+1, 1, poll.len+1));
						} else if(poll.day==1 && !visited[newX][newY][poll.dest+1]) {
							queue.offer(new Point(poll.x, poll.y, poll.dest, 0, poll.len + 1));
						}
					}
				}
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
		int x, y, dest, day, len;

		public Point(int x, int y, int dest, int day, int len) {
			this.x = x;
			this.y = y;
			this.dest = dest;
			this.day = day;
			this.len = len;
		}
	}
}
