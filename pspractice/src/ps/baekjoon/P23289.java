package ps.baekjoon;

// 2022/07/30  19:15~21:30 = 135분
public class P23289 {
	static int r, c, k, w;
	static int[][] dx = {{-1, -1, 0, 1, 1}, {-1, -1, 0, 1, 1}, {0, -1, -1, 0, -1}, {0, 1, 1, 0, 1}}, dy = {
		{0, 1, 1, 0, 1}, {0, -1, -1, 0, -1}, {-1, -1, 0, 1, 1}, {-1, -1, 0, 1, 1}};
	static int[] ddx = {0, 0, -1, 1}, ddy = {1, -1, 0, 0};
	static boolean[][] xWall; // 해당 좌표와 그 위에 벽
	static boolean[][] yWall; // 해당 좌표와 그 오른쪽에 벽
	static boolean[][] visited;
	static int[][] roomInfo, temperature;

	public static void main(String[] args) throws Exception {
		r = read();
		c = read();
		k = read();
		xWall = new boolean[r][c];
		yWall = new boolean[r][c];
		roomInfo = new int[r][c];
		temperature = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				roomInfo[i][j] = read() - 1;
			}
		}
		w = read();
		for (int i = 0; i < w; i++) {
			int x = read() - 1, y = read() - 1, t = read();
			if (t == 1) {
				xWall[x][y] = true;
			} else {
				yWall[x][y] = true;
			}
		}
		int chocolate = 0;
		boolean exit = false;
		while (!exit && chocolate <= 100) {
			exit = true;
			// 1. 모든 온풍기에서 바람 나옴
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (roomInfo[i][j] >= 0 && roomInfo[i][j] <= 3) {
						visited = new boolean[r][c];
						int d = roomInfo[i][j], newX = i + ddx[d], newY = j + ddy[d];
						if (valid(newX, newY) && !isBarrier(i, j, newX, newY, d)) {
							dfs(i + ddx[d], j + ddy[d], d, 5);
						}
					}
				}
			}

			visited = new boolean[r][c];
			int[][] tmpt = new int[r][c];
			for (int i = 0; i < r; i++) {
				System.arraycopy(temperature[i], 0, tmpt[i], 0, c);
			}
			// 2. 온도 조절 - 벽처리
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					visited[i][j] = true;
					for (int a = 0; a < 4; a++) {
						int newX = i + ddx[a], newY = j + ddy[a];
						if (valid(newX, newY) && !isBarrier(i, j, newX, newY, a) && !visited[newX][newY]) {
							int v1 = temperature[i][j] - temperature[newX][newY];
							int v2 = temperature[newX][newY] - temperature[i][j];
							if (v1 > 0) {
								v1 /= 4;
								tmpt[i][j] -= v1;
								tmpt[newX][newY] += v1;
							} else if (v2 > 0) {
								v2 /= 4;
								tmpt[i][j] += v2;
								tmpt[newX][newY] -= v2;
							}
						}
					}
				}
			}

			for (int i = 0; i < r; i++) {
				System.arraycopy(tmpt[i], 0, temperature[i], 0, c);
			}

			for (int i = 0; i < c; i++) {
				if (temperature[0][i] > 0) {
					temperature[0][i]--;
				}
				if (temperature[r - 1][i] > 0) {
					temperature[r - 1][i]--;
				}
			}

			for (int i = 1; i < r - 1; i++) {
				if (temperature[i][0] > 0) {
					temperature[i][0]--;
				}
				if (temperature[i][c - 1] > 0) {
					temperature[i][c - 1]--;
				}
			}

			// 4. 초콜릿 하나 먹기
			chocolate++;

			// 5. 온도 조사칸이 k이상인지 확인하고 중단 결정
			for (int i = 0; i < r && exit; i++) {
				for (int j = 0; j < c && exit; j++) {
					if (roomInfo[i][j] == 4) {
						if (temperature[i][j] < k) {
							exit = false;
						}
					}
				}
			}
		}

		System.out.println(chocolate);
	}

	private static boolean valid(int x, int y) {
		return x >= 0 && y >= 0 && x < r && y < c;
	}

	// d가 0이면 해당 좌표의 위에 벽이있는지, 1이면 해당 좌표의 오른쪽에 벽이 있는지
	static boolean isBarrier(int originX, int originY, int x, int y, int d) {
		if (d == 0) { // 우
			return xWall[originX][originY]; // 기존의 우측에 새좌표가 있는지
		} else if (d == 1) { // 좌
			return xWall[x][y]; // 기존의 왼쪽에 새좌표가 있는지
		} else if (d == 2) { // 상
			return yWall[originX][originY]; // 기존의 위에 새좌표가 있는지
		} else { // 하
			return yWall[x][y]; // 기존의 아래에 새좌표가 있는지
		}
	}

	static boolean isDiagonal(int x, int y, int num, int d) {
		int x1 = x + dx[d][1], y1 = y + dy[d][1], xx1 = x + dx[d][0], yy1 = y + dy[d][0];
		int x3 = x + dx[d][4], y3 = y + dy[d][4], xx3 = x + dx[d][3], yy3 = y + dy[d][3];
		if (num == 0 && valid(x1, y1) && valid(xx1, yy1)) {
			if (d == 0) {
				return !isBarrier(xx1, yy1, x, y, 3) && !isBarrier(xx1, yy1, x1, y1, 0);
			} else if (d == 1) {
				return !isBarrier(xx1, yy1, x, y, 3) && !isBarrier(xx1, yy1, x1, y1, 1);
			} else if (d == 2) {
				return !isBarrier(xx1, yy1, x, y, 0) && !isBarrier(xx1, yy1, x1, y1, 2);
			} else {
				return !isBarrier(xx1, yy1, x, y, 0) && !isBarrier(xx1, yy1, x1, y1, 3);
			}
		} else if (num == 1 && valid(x3, y3) && valid(xx3, yy3)) {
			if (d == 0) {
				return !isBarrier(xx3, yy3, x, y, 2) && !isBarrier(xx3, yy3, x3, y3, 0);
			} else if (d == 1) {
				return !isBarrier(xx3, yy3, x, y, 2) && !isBarrier(xx3, yy3, x3, y3, 1);
			} else if (d == 2) {
				return !isBarrier(xx3, yy3, x, y, 1) && !isBarrier(xx3, yy3, x3, y3, 2);
			} else {
				return !isBarrier(xx3, yy3, x, y, 1) && !isBarrier(xx3, yy3, x3, y3, 3);
			}
		}
		return false;
	}

	private static void dfs(int x, int y, int d, int temp) {
		if (temp != 0) {
			visited[x][y] = true;
			temperature[x][y] += temp;
			if (isDiagonal(x, y, 0, d) && !visited[x + dx[d][1]][y + dy[d][1]]) {
				dfs(x + dx[d][1], y + dy[d][1], d, temp - 1);
			}
			int x2 = x + dx[d][2], y2 = y + dy[d][2];
			if (valid(x2, y2) && !isBarrier(x, y, x2, y2, d) && !visited[x + dx[d][2]][y + dy[d][2]]) {
				dfs(x2, y2, d, temp - 1);
			}
			if (isDiagonal(x, y, 1, d) && !visited[x + dx[d][4]][y + dy[d][4]]) {
				dfs(x + dx[d][4], y + dy[d][4], d, temp - 1);
			}
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
