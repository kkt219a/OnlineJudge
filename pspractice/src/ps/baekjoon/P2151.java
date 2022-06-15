package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/15 해설참조
public class P2151 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[][] map;
	static int n;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	static boolean[][][] visited;
	static int startX, startY, endX, endY;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		visited = new boolean[n][n][4];
		boolean start = false;
		for(int i=0;i<n;i++) {
			char[] chars = br.readLine().toCharArray();
			for(int j=0;j<n;j++) {
				map[i][j] = chars[j];
				if(map[i][j]=='#') {
					if(!start) {
						startX = i;
						startY = j;
						start = true;
					} else {
						endX = i;
						endY = j;
					}
				}
			}
		}
		bfs(startX, startY);
	}

	private static void bfs(int startX, int startY) {
		Queue<Node> queue = new PriorityQueue<>();
		// 시작 # 기준 상하좌우 offer
		for(int i=0;i<4;i++) {
			queue.offer(new Node(startX, startY, i, 0));
		}
		while(!queue.isEmpty()) {
			Node poll = queue.poll();
			int x = poll.x;
			int y = poll.y;
			int mirCnt = poll.mirCnt;
			int dict = poll.dict;
			int newX = x+dx[dict];
			int newY = y+dy[dict];
			visited[x][y][dict] = true;
			if(x==endX&&y==endY) {
				System.out.println(mirCnt);
				return;
			} else if(valid(newX, newY, dict) && map[newX][newY] != '*') {
				queue.offer(new Node(newX,newY,dict, mirCnt));
				if(map[newX][newY] == '!') {
					queue.offer(new Node(newX,newY,(dict+1)%4, mirCnt+1));
					queue.offer(new Node(newX,newY,(dict+3)%4, mirCnt+1));
				}
			}
		}
	}

	private static boolean valid(int x, int y, int dict) {
		return x >= 0 && x < n && y >= 0 && y < n && !visited[x][y][dict];
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int dict;
		int mirCnt;
		public Node(int x, int y, int dict, int mirCnt) {
			this.x = x;
			this.y = y;
			this.dict = dict;
			this.mirCnt = mirCnt;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.mirCnt, o.mirCnt);
		}
	}
}
