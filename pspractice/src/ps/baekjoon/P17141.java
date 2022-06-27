package ps.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 2022/06/27 17:54 ~ 18:34 = 40분
public class P17141 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;
	static boolean[][] arr;
	static boolean[][] arrVisited;
	static List<Point> virus = new ArrayList<>();
	static List<Point> selectedVirus = new ArrayList<>();
	static boolean[] virusVisited;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static int minValue = Integer.MAX_VALUE;
	static int oneNumbering;

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		m = parseIntSt();
		arr = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			newToken();
			for (int j = 0; j < n; j++) {
				int n = parseIntSt();
				arr[i][j] = n != 1;
				if (n == 2) {
					virus.add(new Point(i, j));
				}
				if (n == 1) {
					oneNumbering++;
				}
			}
		}
		virusVisited = new boolean[virus.size()];
		dfs(-1);
		System.out.println(minValue == Integer.MAX_VALUE ? -1 : minValue);
	}

	private static void dfs(int idx) {
		if (selectedVirus.size() == m) {
			arrVisited = new boolean[n][n];
			bfs();
		}
		for (int i = idx + 1; i < virus.size(); i++) {
			if (!virusVisited[i]) {
				virusVisited[i] = true;
				Point oneVirus = virus.get(i);
				selectedVirus.add(oneVirus);
				dfs(i);
				selectedVirus.remove(oneVirus);
				virusVisited[i] = false;
			}
		}
	}

	private static void bfs() {
		int cnt = Integer.MIN_VALUE;
		int numbering = 0;
		PriorityQueue<Spot> queue = new PriorityQueue<>();
		for (Point point : selectedVirus) {
			arrVisited[point.x][point.y] = true;
			queue.add(new Spot(point.x, point.y, 0));
			numbering++;
		}
		while (!queue.isEmpty()) {
			if(cnt > minValue) {
				break;
			}
			Spot poll = queue.poll();
			cnt = Math.max(cnt, poll.time);
			for (int i = 0; i < 4; i++) {
				int newX = poll.x + dx[i], newY = poll.y + dy[i];
				if (newX >= 0 && newX < n && newY >= 0 && newY < n && !arrVisited[newX][newY] && arr[newX][newY]) {
					arrVisited[newX][newY] = true;
					numbering++;
					queue.add(new Spot(newX, newY, poll.time + 1));
				}
			}
		}
		if (numbering + oneNumbering == n * n) {
			minValue = Math.min(cnt, minValue);
		}
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static class Spot implements Comparable<Spot> {
		int x, y, time;

		public Spot(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public int compareTo(Spot o) {
			return Integer.compare(this.time, o.time);
		}
	}
}
