package ps.baekjoon;

// 2022/07/29 18:35~20:25 = 110분
public class P23291 {
	static int n, k, cnt, min, max;
	static int[][] map;
	static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		n = read();
		k = read();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[n - 1][i] = read();
		}
		while (true) {
			min = Integer.MAX_VALUE;
			max = -1;
			for (int i = 0; i < n; i++) { // 2*n
				min = Math.min(min, map[n - 1][i]);
				max = Math.max(max, map[n - 1][i]);
			}
			if (max - min <= k) {
				break;
			}
			for (int i = 0; i < n; i++) {
				if (map[n - 1][i] == min) {
					map[n - 1][i]++;
				}
			}
			map[n - 2][1] = map[n - 1][0];
			map[n - 1][0] = 0;
			int start = 1, height = 2, width = 1;
			while (start + width + height - 1 < n) { // 최종 목적지가 범위를 벗어나지 않는동안
				int t = n - 2;
				for (int i = start + width - 1; i >= start; i--, t--) { // 올릴 친구의 왼쪽(첫번째)부터 오른쪽 끝까지
					for (int j = n - 1, k = 0; j >= 0 && map[j][i] != 0; j--, k++) { // n-1번 적재부터 물고기가 없을 때까지
						map[t][start + width + k] = map[j][i];
						map[j][i] = 0;
					}
				}
				start += width;
				width = height;
				height = n - t - 1;
			}
			int[][] tmp = new int[n][n];
			boolean[][] visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				System.arraycopy(map[i], 0, tmp[i], 0, n);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = true;
					if (map[i][j] != 0) {
						for (int l = 0; l < 4; l++) {
							int newX = i + dx[l], newY = j + dy[l];
							if (newX >= 0 && newY >= 0 && newX < n && newY < n && map[newX][newY] != 0
								&& !visited[newX][newY]) {
								int a = map[i][j] - map[newX][newY];
								int b = map[newX][newY] - map[i][j];
								if (a > 0) {
									tmp[i][j] -= (a / 5);
									tmp[newX][newY] += (a / 5);
								} else if (b > 0) {
									tmp[i][j] += (b / 5);
									tmp[newX][newY] -= (b / 5);
								}
							}
						}
					}
				}
			}
			int c = 0;
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0 && map[j][i] != 0; j--) {
					map[n - 1][c++] = tmp[j][i];
				}
			}
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = 0;
				}
			}
			int p = n / 2;
			for (int i = 0, j = p - 1; i < p; i++, j--) {
				map[n - 2][p + i] = map[n - 1][j];
				map[n - 1][j] = 0;
			}
			p += p / 2;
			for (int l = n - 3, q = n - 2; l > n - 5; l--, q++) {
				int i = p;
				for (int j = p - 1; i < n; i++, j--) {
					map[l][i] = map[q][j]; // [n-3][4+0
					map[q][j] = 0;
				}
			}
			visited = new boolean[n][n];
			tmp = new int[n][n];
			for (int i = 0; i < n; i++) {
				System.arraycopy(map[i], 0, tmp[i], 0, n);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = true;
					if (map[i][j] != 0) {
						for (int l = 0; l < 4; l++) {
							int newX = i + dx[l], newY = j + dy[l];
							if (newX >= 0 && newY >= 0 && newX < n && newY < n && map[newX][newY] != 0
								&& !visited[newX][newY]) {
								int a = map[i][j] - map[newX][newY];
								int b = map[newX][newY] - map[i][j];
								if (a > 0) {
									tmp[i][j] -= (a / 5);
									tmp[newX][newY] += (a / 5);
								} else if (b > 0) {
									tmp[i][j] += (b / 5);
									tmp[newX][newY] -= (b / 5);
								}
							}
						}
					}
				}
			}
			c = 0;
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0 && map[j][i] != 0; j--) {
					map[n - 1][c++] = tmp[j][i];
				}
			}
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = 0;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
		// 물고기 수가 가장 적은 어항들에 물고기 한 마리를 넣는다.
		// 가장 왼쪽에 있는 어항을 그 오른쪽에 있는 어항 위로 올림
		// 2개 이상 쌓인 어항의 열을 시계 방향으로 90도 회전시켜서 바닥 가장 왼쪽의 어항 위에
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
