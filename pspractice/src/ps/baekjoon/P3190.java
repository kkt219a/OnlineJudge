package ps.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/07/07 17:11 ~ 17:46 = 35분
public class P3190 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k, l;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static Queue<Point> dirs = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		n = read();
		map = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];
		k = read();
		for (int i = 0; i < k; i++) {
			int x = read();
			int y = read();
			map[x][y] = 1;
		}
		l = read();
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int d = st.nextToken().charAt(0) == 'L' ? -1 : 1;
			dirs.add(new Point(time, d));
		}
		int time = 0, dir = 0;
		Deque<Point> body = new LinkedList<>();
		body.add(new Point(1, 1));
		boolean end = false;
		while (!end) {
			Point last = body.getLast();
			Point next = new Point(last.x + dx[dir], last.y + dy[dir]);
			if (next.x > 0 && next.x <= n && next.y > 0 && next.y <= n && !visited[next.x][next.y]) {
				body.offer(next);
				visited[next.x][next.y] = true;
				if (map[next.x][next.y] == 1) {
					map[next.x][next.y] = 0;
				} else {
					Point remove = body.poll();
					visited[remove.x][remove.y] = false;
				}
			} else {
				end = true;
			}
			time++;
			if (!dirs.isEmpty() && dirs.peek().x == time) {
				dir = (dir + dirs.poll().y + 4) % 4;
			}
		}
		System.out.println(time);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
