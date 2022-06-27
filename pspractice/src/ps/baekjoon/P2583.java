package ps.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/27 17:29 ~ 17:49 = 20분
public class P2583 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m, k, sum;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
	static List<Integer> lists = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		newToken();
		m = parseIntSt();
		n = parseIntSt();
		k = parseIntSt();
		map = new boolean[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < k; i++) {
			newToken();
			int a = parseIntSt();
			int b = parseIntSt();
			int c = parseIntSt();
			int d = parseIntSt();
			for (int j = b; j < d; j++) {
				for (int p = a; p < c; p++) {
					map[j][p] = true;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && !map[i][j]) {
					bfs(i, j);
				}
			}
		}
		Collections.sort(lists);
		sb.append(sum).append("\n");
		for (Integer list : lists) {
			sb.append(list).append(" ");
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.offer(new Point(x, y));
		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;
			Point poll = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = poll.x + dx[i], newY = poll.y + dy[i];
				if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && !map[newX][newY]) {
					visited[newX][newY] = true;
					queue.offer(new Point(newX, newY));
				}
			}
		}
		sum++;
		lists.add(cnt);
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
