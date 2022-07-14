package ps.baekjoon;

import java.awt.*;
import java.util.Arrays;

// 2022/07/13 15:08 ~ 15:50 = 42분
public class P2573 {
	static int n, m;
	static int[][] map;
	static int[] dx = {0,1,0,-1}, dy={1,0,-1,0};
	static boolean[][] visited;
	static Point start = null;
	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		map = new int[n][m];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = read();
				if(map[i][j]!=0) {
					if(start == null) {
						start = new Point(i,j);
					}
					cnt++;
				}
			}
		}
		int time = 0;
		boolean search = false;
		while(cnt != 0) {
			visited = new boolean[n][m];
			if(cnt!=dfs(start.x, start.y)) {
				search = true;
				break;
			}
			start = null;
			cnt = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					for (int k = 0; k < 4 && map[i][j] > 0; k++) {
						int x = i + dx[k], y = j + dy[k];
						if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 0 && !visited[x][y]) {
							map[i][j]--;
						}
					}
					if(map[i][j]!=0) {
						if(start == null) {
							start = new Point(i,j);
						}
						cnt++;
					}
				}
			}
			time++;
		}
		System.out.println(search ? time : 0);

	}

	private static int dfs(int a, int b) {
		visited[a][b] = true;
		int cnt = 0;
		for(int i=0;i<4;i++) {
			int x = a + dx[i], y = b + dy[i];
			if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] != 0 && !visited[x][y]) {
				cnt += dfs(x,y);
			}
		}
		return cnt+1;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
