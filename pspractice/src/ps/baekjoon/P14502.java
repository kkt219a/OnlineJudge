package ps.baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 2022/07/07 01:55 ~ 02:12 = 17분
public class P14502 {
	static int n,m;
	static int[][] map;
	static boolean[][] visited;
	static List<Point> virus = new ArrayList<>();
	static int oneCnt = 3;
	static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
	static int maxV = Integer.MIN_VALUE;
	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		map = new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				map[i][j] = read();
				if(map[i][j] == 2) {
					virus.add(new Point(i,j));
				} else if(map[i][j] == 1) {
					oneCnt++;
				}
			}
		}
		dfs(0, 0);
		System.out.println(maxV);
	}

	private static void dfs(int start, int depth) {
		if(depth == 3) {
			maxV = Math.max(maxV, bfs());
		} else if(depth < 3) {
			for (int i = start; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 0) {
						map[i][j] = 1;
						dfs(i, depth + 1);
						map[i][j] = 0;
					}
				}
			}
		}
	}

	private static int bfs() {
		int cnt = 0;
		visited = new boolean[n][m];
		Queue<Point> viruses = new LinkedList<>();
		for (Point point : virus) {
			viruses.add(point);
			visited[point.x][point.y] = true;
		}
		while(!viruses.isEmpty()) {
			cnt++;
			Point v = viruses.poll();
			for(int i=0;i<4;i++) {
				int x = v.x+dx[i], y = v.y+dy[i];
				if(x>=0&&x<n&&y>=0&&y<m&&!visited[x][y]&&map[x][y]!=1) {
					visited[x][y] = true;
					viruses.offer(new Point(x,y));
				}
			}
		}
		return n*m - cnt - oneCnt;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
