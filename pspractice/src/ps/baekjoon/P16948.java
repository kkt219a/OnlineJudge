package ps.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/05/29 18:27 ~ 18:37 = 10분
public class P16948 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Point end;
	static boolean[][] visited;
	static int n;
	static Queue<CntPoint> queue = new LinkedList<>();
	static int ans = -1;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n][n];
		String[] infos = br.readLine().split(" ");
		end = new Point(Integer.parseInt(infos[2]),Integer.parseInt(infos[3]));
		bfs(new Point(Integer.parseInt(infos[0]),Integer.parseInt(infos[1])));
		System.out.println(ans);
	}

	private static void bfs(Point start) {
		queue.offer(new CntPoint(start.x, start.y, 0));
		visited[start.x][start.y] = true;
		while(!queue.isEmpty()) {
			CntPoint point = queue.poll();
			if(point.x == end.x && point.y == end.y) {
				ans = point.cnt;
				break;
			}
			enqueue(point.x-2, point.y-1,point.cnt);
			enqueue(point.x-2, point.y+1,point.cnt);
			enqueue(point.x, point.y-2,point.cnt);
			enqueue(point.x, point.y+2,point.cnt);
			enqueue(point.x+2, point.y-1,point.cnt);
			enqueue(point.x+2, point.y+1,point.cnt);
		}
	}

	private static void enqueue(int x, int y, int cnt) {
		if(x>=0&&x<n&&y>=0&&y<n&&!visited[x][y]) {
			visited[x][y] = true;
			queue.offer(new CntPoint(x,y,cnt+1));
		}
	}

	static class CntPoint {
		int x;
		int y;
		int cnt;
		public CntPoint(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
