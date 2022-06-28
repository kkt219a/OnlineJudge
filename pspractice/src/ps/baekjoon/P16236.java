package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/28 21:01 ~ 21:27, 22:46~ 22:36 = 76분
public class P16236 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, distance;
	static int[][] map;
	static boolean[][] visited;
	static Shark shark;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		n = parseIntBr();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			newToken();
			for (int j = 0; j < n; j++) {
				map[i][j] = parseIntSt();
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				}
			}
		} // 02 21

		while (true) { // 상어는 매번 BFS하며 먹이를 찾는다.
			visited = new boolean[n][n]; // 방문 내역은 초기화한다.
			Queue<Point> queue = new LinkedList<>();
			queue.offer(new Point(shark.x, shark.y, 0)); // 상어가 있는 위치를 넣고
			visited[shark.x][shark.y] = true; // 방문했다고 알린다.
			Point temp = new Point(21, 21, 50);
			boolean cont = true;
			while (!queue.isEmpty()) {
				Point poll = queue.poll();
				if (!cont && temp.cnt < poll.cnt) { // 진행할 수 없는데 거리가 더 길면 남아있어도 중단
					break;
				}
				// // 방문 지점이 물고기고, 상어가 먹을 수 있으며, 같은 cnt가 존재한다면
				if (map[poll.x][poll.y] != 0 && map[poll.x][poll.y] < shark.level
					&& (poll.x < temp.x || (poll.x == temp.x && poll.y < temp.y))) {
					// // 더 위에있거나, 높이가 같은데 더 왼쪽이라면 교체
					temp = new Point(poll.x, poll.y, poll.cnt);
					cont = false;
				}
				if (cont) {
					for (int i = 0; i < 4; i++) {
						int newX = poll.x + dx[i], newY = poll.y + dy[i];
						// 상어보다 레벨이 작거나 같고, 방문하지 않았으면 방문
						if (newX >= 0 && newX < n && newY >= 0 && newY < n
							&& map[newX][newY] <= shark.level && !visited[newX][newY]) {
							visited[newX][newY] = true;
							queue.offer(new Point(newX, newY, poll.cnt + 1));
						}
					}
				}
			}
			if (temp.cnt == 50) {
				break;
			} else {
				distance += temp.cnt;
				map[temp.x][temp.y] = 0;
				shark.x = temp.x;
				shark.y = temp.y;
				shark.eat();
			}
		}
		System.out.println(distance);
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static class Shark {
		int x, y, level, exp;

		public Shark(int x, int y, int level, int exp) {
			this.x = x;
			this.y = y;
			this.level = level;
			this.exp = exp;
		}

		public void eat() {
			exp++;
			if (exp == level) {
				exp = 0;
				level++;
			}
		}
	}

	static class Point {
		int x, y, cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
