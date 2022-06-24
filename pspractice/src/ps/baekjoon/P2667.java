package ps.baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 2022/06/24 16:22 ~ 16:32 = 10분
public class P2667 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static List<Integer> sum = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			char[] s = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = s[j] != '0';
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j]) {
					visited[i][j] = true;
					bfs(i, j);
				}
			}
		}
		Collections.sort(sum);
		sb.append(sum.size()).append("\n");
		for (Integer integer : sum) {
			sb.append(integer).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));
		int cnt = 0;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int newX = p.x + dx[i];
				int newY = p.y + dy[i];
				if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited[newX][newY] && map[newX][newY]) {
					visited[newX][newY] = true;
					queue.offer(new Point(newX, newY));
				}
			}
		}
		sum.add(cnt);
	}
}
