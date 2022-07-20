package ps.baekjoon;

// 2022/07/19 17:56 ~ 18:11 = 15분
public class P10159 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int n = read();
		int m = read();
		short[][] map = new short[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int a = read(), b = read();
			map[a][b] = -1;
			map[b][a] = 1;
		}
		for (int mid = 1; mid <= n; mid++) {
			for (int start = 1; start <= n; start++) {
				for (int end = 1; end <= n; end++) {
					if (map[start][mid] == map[mid][end] && map[start][mid] != 0) {
						map[start][end] = map[start][mid];
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (i != j && map[i][j] == 0) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}
