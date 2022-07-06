package ps.baekjoon;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 2022/07/07 02:25 ~ 02:47 = 22분
public class P16234 {
	static int[][] map;
	static int n, l, r, days;
	static boolean[][] visited;
	static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};

	public static void main(String[] args) throws Exception {
		n = read();
		l = read();
		r = read();
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = read();
			}
		}
		for(boolean exit = false;!exit;days++) {
			exit = true;
			visited = new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(!visited[i][j] && bfs(i,j)) {
						exit = false;
					}
				}
			}
		}
		System.out.println(days-1);
	}

	private static boolean bfs(int a, int b) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(a,b));
		visited[a][b] = true;
		List<Point> visitedPoints = new ArrayList<>();
		int sum = 0;
		while(!queue.isEmpty()) {
			Point poll = queue.poll();
			int nowPeople = map[poll.x][poll.y];
			sum += map[poll.x][poll.y];
			visitedPoints.add(poll);
			for(int i=0;i<4;i++) {
				int x = poll.x+dx[i], y = poll.y+dy[i];
				if(x>=0&&x<n&&y>=0&&y<n&&!visited[x][y]&&Math.abs(map[x][y]-nowPeople)>=l&&Math.abs(map[x][y]-nowPeople)<=r) {
					visited[x][y] = true;
					queue.offer(new Point(x,y));
				}
			}
		}
		if(visitedPoints.size() == 1) {
			return false;
		}
		sum /= visitedPoints.size();
		for (Point p : visitedPoints) {
			map[p.x][p.y] = sum;
		}
		return true;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
