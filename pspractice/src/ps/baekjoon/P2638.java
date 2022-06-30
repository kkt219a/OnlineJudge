package ps.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/30 18:48 ~ 19:50 = 62분
public class P2638 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int meltTime;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static int n, m;

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		m = parseIntSt();
		map = new boolean[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			newToken();
			for (int j = 0; j < m; j++) {
				map[i][j] = parseIntSt() == 1;
			}
		}
		bfs();
		System.out.println(meltTime);
	}

	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0));
		for (; ; meltTime++) {
			boolean melted = false;
			while (!queue.isEmpty()) {
				Point now = queue.poll();
				visited[now.x][now.y] = true;
				for (int i = 0; i < 4; i++) {
					int newX = now.x + dx[i], newY = now.y + dy[i];
					if (checked(newX, newY) && !map[newX][newY] && !visited[newX][newY]) {
						queue.offer(new Point(newX, newY));
						visited[newX][newY] = true;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (isMelted(i, j)) {
						map[i][j] = false;
						queue.offer(new Point(i, j));
						melted = true;
					}
				}
			}
			if (!melted) {
				break;
			}
		}
	}

	private static boolean isMelted(int x, int y) {
		if (map[x][y]) {
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i], newY = y + dy[i];
				if (checked(newX, newY) && !map[newX][newY] && visited[newX][newY]) {
					cnt++;
				}
			}
			return cnt >= 2;
		}
		return false;
	}

	private static boolean checked(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
