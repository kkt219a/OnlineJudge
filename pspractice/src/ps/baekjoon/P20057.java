package ps.baekjoon;

import java.awt.*;
import java.util.Arrays;

// 2022/07/25 17:40 ~18:03, 22:26~22:46/ 23:37~ xx:xx = xx분
public class P20057 {
	static int n, dir=0, x, y, moveSand;
	static int[][] map;
	static int[] dx = {0,1,0,-1}, dy = {-1,0,1,0};
	static boolean[][] visited;
	//모래 복사, 알파 지점은 인덱스 4, ddd는 비율
	static int[] ddx = {-1,-1,-1,-2,0,1,1,1,2,0}, ddy = {0,-1,1,0,-2,-1,0,1,0,-1};
	static double[] ddd={0.07,0.10,0.01,0.02,0.05,0.10,0.07,0.01,0.02,0.45};
	public static void main(String[] args) throws Exception {
		n = read();
		map = new int[n][n];
		visited = new boolean[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				map[i][j] = read();
			}
		}
		x = n/2;
		y = n/2;
		while(!(x==0 && y==0)) {
			visited[x][y] = true;
			// 이동하기
			x += dx[dir];
			y += dy[dir];
			// 토네이도가 불고
			for(int i=0;i<10;i++) {
				int newX = x+ddx[i], newY = y+ddy[i], sand = (int)Math.floor(map[x][y]*ddd[i]);
				if(newX>=0&&newY>=0&&newX<n&&newY<n) {
					map[newX][newY] += sand;
				} else {
					moveSand += sand;
				}
			}
			if(dir==0&&!visited[x+dx[1]][y+dy[1]]) {
				dir = 1;
			} else if(dir==1&&!visited[x+dx[2]][y+dy[2]]) {
				dir = 2;
			} else if(dir==2&&!visited[x+dx[3]][y+dy[3]]) {
				dir = 3;
			} else if(dir==3&&!visited[x+dx[0]][y+dy[0]]) {
				dir = 0;
			}
			for (int[] ints : map) {
				System.out.println(Arrays.toString(ints));
			}
			System.out.println();
		}
		System.out.println(moveSand);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
