package ps.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 2022/07/11 15:37 ~ 16:17 = 40분
public class P11559 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map = new char[12][6];
	static boolean[][] visited;
	static int boom;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		boolean cont = true;
		while (cont) {
			visited = new boolean[12][6];
			cont = false;
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.' && bfs(i, j)) {
						cont = true;
					}
				}
			}
			for (int i = 0; i < 6; i++) {
				for (int j = 11; j >= 0; j--) {
					if (map[j][i] == '.') {
						for (int k = j - 1; k >= 0; k--) {
							if (map[k][i] != '.') {
								char tmp = map[k][i];
								map[k][i] = map[j][i];
								map[j][i] = tmp;
								break;
							}
						}
					}
				}
			}
			if (cont) {
				boom++;
			}
		}
		System.out.println(boom);
	}

	private static boolean bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		visited[x][y] = true;
		List<Point> pop = new ArrayList<>();
		while (!queue.isEmpty()) {
			Point poll = queue.poll();
			pop.add(poll);
			for (int i = 0; i < 4; i++) {
				int newX = poll.x + dx[i], newY = poll.y + dy[i];
				if (newX >= 0 && newX < 12 && newY >= 0 && newY < 6 && map[newX][newY] == map[x][y]
					&& !visited[newX][newY]) {
					queue.offer(new Point(newX, newY));
					visited[newX][newY] = true;
				}
			}
		}
		if (pop.size() >= 4) {
			for (Point point : pop) {
				map[point.x][point.y] = '.';
			}
			return true;
		}
		return false;
	}
}
