package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

// 2022/05/28 10:28 ~ 10:51 = 23분
public class P16174 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String[] infos = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(infos[j]);
			}
		}
		bfs();
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(0, 0, map[0][0]));
		visited[0][0] = true;
		boolean success = false;
		while (!queue.isEmpty()) {
			Point point = queue.poll();
			if (point.value == -1) {
				success = true;
				break;
			}
			point.getRight().ifPresent(v -> {
				queue.offer(v);
				visited[v.x][v.y] = true;
			});
			point.getDown().ifPresent(v -> {
				queue.offer(v);
				visited[v.x][v.y] = true;
			});
		}
		System.out.println(success ? "HaruHaru" : "Hing");
	}

	static class Point {
		int x;
		int y;
		int value;

		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}

		public Optional<Point> getRight() {
			return y + value < map.length && value != 0 && !visited[x][y + value] ?
				Optional.of(new Point(x, y + value, map[x][y + value])) : Optional.empty();
		}

		public Optional<Point> getDown() {
			return x + value < map.length && value != 0 && !visited[x + value][y] ?
				Optional.of(new Point(x + value, y, map[x + value][y])) : Optional.empty();
		}
	}
}
