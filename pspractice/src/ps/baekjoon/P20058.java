package ps.baekjoon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 2022/07/25 120분
public class P20058 {
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	static int n, rn, q, ans, cnt;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		n = read();
		q = read();
		rn = (int)Math.pow(2, n);
		map = new int[rn][rn];
		for (int i = 0; i < rn; i++) {
			for (int j = 0; j < rn; j++) {
				map[i][j] = read();
			}
		}
		for (int i = 0; i < q; i++) {
			int l = read();
			if (l != 0) {
				divide((int)Math.pow(2, l), rn, 0, 0);
			}
			List<int[]> list = new ArrayList<>();
			for (int j = 0; j < rn; j++) {
				for (int k = 0; k < rn; k++) {
					int cnt = 0;
					if (map[j][k] != 0) {
						for (int p = 0; p < 4; p++) {
							int newX = j + dx[p], newY = k + dy[p];
							if (newX >= 0 && newY >= 0 && newX < rn && newY < rn && map[newX][newY] > 0) {
								cnt++;
							}
						}
						if (cnt < 3) {
							list.add(new int[] {j, k});
						}
					}
				}
			}
			for (int[] ints : list) {
				map[ints[0]][ints[1]]--;
			}
		}
		visited = new boolean[rn][rn];
		for (int i = 0; i < rn; i++) {
			for (int j = 0; j < rn; j++) {
				cnt += map[i][j];
				if (!visited[i][j] && map[i][j] != 0) {
					ans = Math.max(ans, bfs(i, j));
				}
			}
		}
		System.out.println(cnt + " " + ans);
	}

	static void divide(int l, int now, int startX, int startY) {
		if (l == now) {
			copy(startX, startY, l);
		} else {
			int newNow = now / 2;
			divide(l, newNow, startX, startY);
			divide(l, newNow, startX, startY + newNow);
			divide(l, newNow, startX + newNow, startY);
			divide(l, newNow, startX + newNow, startY + newNow);
		}
	}

	private static void copy(int startX, int startY, int l) {
		int[][] copy = new int[l][l];
		for (int copyY = l - 1, originX = startX; originX < startX + l; copyY--, originX++) {
			for (int copyX = 0, originY = startY; originY < startY + l; copyX++, originY++) {
				copy[copyX][copyY] = map[originX][originY];
			}
		}
		for (int i = startX, k=0; i < startX + l; i++,k++) {
			for (int j = startY,p=0; j < startY + l; j++,p++) {
				map[i][j] = copy[k][p];
			}
		}
	}

	static int bfs(int x, int y) {
		int cnt = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int newX = poll[0] + dx[i], newY = poll[1] + dy[i];
				if (newX >= 0 && newY >= 0 && newX < rn && newY < rn && !visited[newX][newY] && map[newX][newY] != 0) {
					queue.offer(new int[] {newX, newY});
					visited[newX][newY] = true;
				}
			}
		}
		return cnt;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
