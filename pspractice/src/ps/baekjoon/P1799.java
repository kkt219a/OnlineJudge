package ps.baekjoon;

// 2022/07/15 풀이 참조
public class P1799 {
	static int n, max=-1, ans;
	static boolean[] dl, dr;
	static boolean[][] map;

	public static void main(String[] args) throws Exception {
		n = read();
		map = new boolean[n][n];
		dl = new boolean[2*n-1];
		dr = new boolean[2*n-1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = read() == 1;
			}
		}
		dfs(0,0, 0);
		ans += max;
		max = -1;
		dfs(0,1, 0);
		ans += max;
		System.out.println(ans);
	}

	private static void dfs(int depth, int odd, int row) {
		max = Math.max(max, depth);
		for(int i=row;i<n;i++) {
			int j = (i%2 == 0 && odd == 0) || (i%2 == 1 && odd == 1) ? 0 : 1;
			for(;j<n;j+=2) {
				if(map[i][j]&&!dl[i+j]&&!dr[n-1-i+j]) {
					dl[i+j] = true;
					dr[n-1-i+j] = true;
					map[i][j] = false;
					dfs(depth+1, odd, i);
					map[i][j] = true;
					dl[i+j] = false;
					dr[n-1-i+j] = false;
				}
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
