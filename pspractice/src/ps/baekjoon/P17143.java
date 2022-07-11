package ps.baekjoon;

import java.awt.*;
import java.util.Arrays;

// 2022/07/11 16:34 ~ 17:27 = 53분
public class P17143 {
	static int r,c,m, get;
	static int[] dx = {-1,1,0,0}, dy = {0,0,1,-1};
	static Shark[][] map;
	public static void main(String[] args) throws Exception {
		r = read();
		c = read();
		m = read();
		map = new Shark[r+1][c+1];
		for(int i=0;i<m;i++) {
			int x = read(), y = read();
			map[x][y] = new Shark(read(), read(), read());
		}
		for(int i=1;i<=c;i++) {

			for(int j=1;j<=r;j++) {
				if(map[j][i] != null) {
					get += map[j][i].size;
					map[j][i] = null;
					break;
				}
			}
			Shark[][] temp = new Shark[r+1][c+1];
			for(int j=1;j<=r;j++) {
				for(int k=1;k<=c;k++) {
					if(map[j][k] != null) {
						Point move = map[j][k].move(j, k);
						if(temp[move.x][move.y] != null) {
							if(temp[move.x][move.y].size < map[j][k].size) {
								temp[move.x][move.y] = map[j][k];
							}
						} else {
							temp[move.x][move.y] = map[j][k];
						}
					}
				}
			}
			for(int j=1;j<=r;j++) {
				System.arraycopy(temp[j], 1, map[j], 1, c);
			}
		}
		System.out.println(get);
	}

	static class Shark {
		int velocity, direction, size;
		public Shark(int velocity, int direction, int size) {
			this.velocity = velocity;
			this.direction = direction-1;
			this.size = size;
		}

		Point move(int x, int y) {
			int tmp = velocity;
			Point p = new Point(x, y);
			while(tmp != 0) {
				int dist = 0;
				if(direction==0) {
					dist = Math.min(tmp, p.x-1);
					p.move(p.x - dist, p.y);
					if(dist != tmp) {
						direction = 1;
					}
				} else if(direction==1) {
					dist = Math.min(tmp, r - p.x);
					p.move(p.x+dist, p.y);
					if(dist != tmp) {
						direction = 0;
					}
				} else if(direction==2) {
					dist = Math.min(tmp, c-p.y);
					p.move(p.x, p.y+dist);
					if(dist != tmp) {
						direction = 3;
					}
				} else {
					dist = Math.min(tmp, p.y-1);
					p.move(p.x, p.y-dist);
					if(dist != tmp) {
						direction = 2;
					}
				}
				tmp -= dist;
			}
			return p;
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
