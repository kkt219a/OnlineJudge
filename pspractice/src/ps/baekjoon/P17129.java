package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/05 17:58 ~ 18:18 = 20분
public class P17129 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	static int minV = Integer.MAX_VALUE;
	static int startX, startY;


	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			String split = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j] = split.charAt(j) - '0';
				if(map[i][j]==2) {
					startX = i;
					startY = j;
				}
			}
		}
		bfs(startX, startY);
		System.out.println(minV == Integer.MAX_VALUE ? "NIE" : "TAK\n"+minV);
	}

	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x,y,0));
		visited[x][y] = true;
		while(!queue.isEmpty()) {
			Point poll = queue.poll();
			if(map[poll.x][poll.y] == 3 || map[poll.x][poll.y] == 4 || map[poll.x][poll.y] == 5) {
				minV = Math.min(minV, poll.cnt);
				break;
			}
			for(int i=0;i<4;i++) {
				if(poll.x+dx[i] >= 0 && poll.y+dy[i] >= 0 && poll.x+dx[i] < n && poll.y+dy[i] <m
					&& map[poll.x+dx[i]][poll.y+dy[i]] != 1 && !visited[poll.x+dx[i]][poll.y+dy[i]]) {
					queue.offer(new Point(poll.x+dx[i],poll.y+dy[i], poll.cnt+1));
					visited[poll.x+dx[i]][poll.y+dy[i]] = true;
				}
			}
		}
	}

	static class Point {
		int x;
		int y;
		int cnt;
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
