package ps.baekjoon;

// 2022/07/25 116분
public class P20057 {
	static int n, dir = 0, x, y, moveSand;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
	static boolean[][] visited;
	//모래 복사, 알파 지점은 인덱스 4, ddd는 비율
	static int[] ddx = new int[] {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0}, ddy = new int[] {0, -1, 0, 1, -2, -1, 0, 1, 0, -1};
	static double[] ddd = new double[] {0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02, 0};

	public static void main(String[] args) throws Exception {
		n = read();
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = read();
			}
		}
		x = n / 2;
		y = n / 2;
		while (!(x == 0 && y == 0)) {
			visited[x][y] = true;
			// 이동하기
			x += dx[dir];
			y += dy[dir];
			int cnt = map[x][y];
			// 토네이도가 불고
			for (int i = 0; i < 9; i++) {
				int newX = x + ddx[i], newY = y + ddy[i], sand = (int)Math.floor(map[x][y] * ddd[i]);
				if (newX >= 0 && newY >= 0 && newX < n && newY < n) {
					map[newX][newY] += sand;
				} else {
					moveSand += sand;
				}
				cnt -= sand;
			}
			if (x + ddx[9] >= 0 && y + ddy[9] >= 0 && x + ddx[9] < n && y + ddy[9] < n) {
				map[x + ddx[9]][y + ddy[9]] += cnt;
			} else {
				moveSand += cnt;
			}
			map[x][y] = 0;
			if (dir == 0 && !visited[x + dx[1]][y + dy[1]]) {
				dir = 1;
				ddx = new int[] {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1};
				ddy = new int[] {-1, 1, -2, -1, 1, 2, -1, 1, 0, 0};
				ddd = new double[] {0.01, 0.01, 0.02, 0.07, 0.07, 0.02, 0.1, 0.1, 0.05, 0};
			} else if (dir == 1 && !visited[x + dx[2]][y + dy[2]]) {
				dir = 2;
				ddx = new int[] {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0};
				ddy = new int[] {0, -1, 0, 1, 2, -1, 0, 1, 0, 1};
				ddd = new double[] {0.02, 0.01, 0.07, 0.1, 0.05, 0.01, 0.07, 0.1, 0.02, 0};
			} else if (dir == 2 && !visited[x + dx[3]][y + dy[3]]) {
				dir = 3;
				ddx = new int[] {-2, -1, -1, 0, 0, 0, 0, 1, 1, -1};
				ddy = new int[] {0, -1, 1, -2, -1, 1, 2, -1, 1, 0};
				ddd = new double[] {0.05, 0.1, 0.1, 0.02, 0.07, 0.07, 0.02, 0.01, 0.01, 0};
			} else if (dir == 3 && !visited[x + dx[0]][y + dy[0]]) {
				dir = 0;
				ddx = new int[] {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0};
				ddy = new int[] {0, -1, 0, 1, -2, -1, 0, 1, 0, -1};
				ddd = new double[] {0.02, 0.1, 0.07, 0.01, 0.05, 0.1, 0.07, 0.01, 0.02, 0};
			}
		}
		System.out.println(moveSand);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
