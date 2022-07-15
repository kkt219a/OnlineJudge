package ps.baekjoon;

// 2022/07/14 17:36 ~ xx:xx = xx분
public class P1799 {
	static int n, max=-1;

	public static void main(String[] args) throws Exception {
		n = read();
		boolean[][] origin = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				origin[i][j] = read() == 1;
			}
		}
		dfs(origin, 0);
		System.out.println(max);
	}

	private static void dfs(boolean[][] map, int depth) {
		max = Math.max(max, depth);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]) {
					dfs(painting(map, i, j), depth+1);
				}
			}
		}
	}

	public static boolean[][] painting(boolean[][] map, int x, int y) {
		boolean[][] ret = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, ret[i], 0, n);
		}
		ret[x][y] = false;
		for (int i = x + 1, j = y + 1; i < n && j < n; i++, j++) {
			ret[i][j] = false;
		}
		for (int i = x + 1, j = y - 1; i < n && j >= 0; i++, j--) {
			ret[i][j] = false;
		}
		for (int i = x - 1, j = y + 1; i >= 0 && j < n; i--, j++) {
			ret[i][j] = false;
		}
		for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
			ret[i][j] = false;
		}
		return ret;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
