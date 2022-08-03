package ps.baekjoon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 2022/08/03 21:33 ~ 21:46 /22:02 ~ 22:17  = 28분
public class P17142 {
	static int n, m, emp, realTime = Integer.MAX_VALUE;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static int[][] map;
	static List<Point> initVirus = new ArrayList<>();
	static List<Point> realVirus = new ArrayList<>();
	static boolean[][] visitedVirus;
	static boolean[][] mapVisited;

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		map = new int[n][n];
		visitedVirus = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = read();
				if (map[i][j] == 2) {
					initVirus.add(new Point(i, j));
				} else if (map[i][j] == 0) {
					emp++;
				}
			}
		}
		dfs(0, -1);
		System.out.println(realTime == Integer.MAX_VALUE ? -1 : realTime);
	}

	private static void dfs(int num, int start) {
		if (num == m) {
			bfs();
		} else {
			for (int i = start + 1, j = initVirus.size(); i < j; i++) {
				Point virus = initVirus.get(i);
				if (!visitedVirus[virus.x][virus.y]) {
					realVirus.add(virus);
					visitedVirus[virus.x][virus.y] = true;
					dfs(num + 1, i);
					visitedVirus[virus.x][virus.y] = false;
					realVirus.remove(virus);
				}
			}
		}
	}

	private static void bfs() {
		Queue<Point> queue = new ArrayDeque<>();
		int tmpEmp = emp, time = 0;
		int[][] copyMap = new int[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, copyMap[i], 0, n);
		}
		mapVisited = new boolean[n][n];
		for (Point virus : realVirus) {
			mapVisited[virus.x][virus.y] = true;
			queue.offer(new Point(virus.x, virus.y, 0));
		}
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			if(copyMap[poll.x][poll.y]==0) {
				time = Math.max(time, poll.time);
			}
			for (int i = 0; i < 4; i++) {
				int x = poll.x + dx[i], y = poll.y + dy[i];
				if (x >= 0 && y >= 0 && x < n && y < n && !mapVisited[x][y] && copyMap[x][y] != 1) {
					mapVisited[x][y] = true;
					if (copyMap[x][y] == 0) {
						tmpEmp--;
					}
					queue.offer(new Point(x, y, poll.time + 1));
				}
			}
		}
		if (tmpEmp == 0) {
			realTime = Math.min(realTime, time);
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class Point {
		int x, y, time;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
}
