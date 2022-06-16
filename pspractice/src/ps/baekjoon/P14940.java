package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/16 14:56 ~ 15:09 = 13분
public class P14940 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;
	static int[][] maps;
	static int[][] dist;
	static boolean[][] visited;
	static int startX, startY;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maps = new int[n+1][m+1];
		dist = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				maps[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = maps[i][j] == 1 ? -1:0;
				if(maps[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		bfs();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				sb.append(dist[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(startX, startY, 0));
		visited[startX][startY] = true;
		while(!queue.isEmpty()) {
			Point cur = queue.poll();
			dist[cur.x][cur.y] = cur.cost;
			for(int i=0;i<4;i++) {
				int newX = cur.x+dx[i];
				int newY = cur.y+dy[i];
				if(newX>=1&&newX<=n&&newY>=1&&newY<=m&&!visited[newX][newY]&&maps[newX][newY]!=0) {
					visited[newX][newY] = true;
					queue.offer(new Point(newX, newY, cur.cost+1));
				}
			}
		}
	}

	static class Point {
		int x, y, cost;

		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
