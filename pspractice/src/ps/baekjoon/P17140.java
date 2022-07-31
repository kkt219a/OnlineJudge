package ps.baekjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 2022/07/31 17:51 ~ 18:32/ 20:14 ~ 20:33 / 01:37 ~ 01:53 = 76분
public class P17140 {
	static int r, c, k, n = 3, m = 3, time = 0;
	static int[][] arr = new int[100][100];
	static Queue<Point> queue = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		// 최초 n,m은 3으로 잡자. r과 c가 n과 m보다 작거나 같지 않으면 무시하자.
		r = read() - 1;
		c = read() - 1;
		k = read();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = read();
			}
		}

		while (time < 101 && arr[r][c] != k) {
			// r연산
			if (n >= m) {
				int tmp = -1;
				for (int i = 0; i < n; i++) {
					int[] rCnt = new int[101];
					int max = -1;
					for (int j = 0; j < m; j++) {
						rCnt[arr[i][j]]++;
						max = Math.max(max,arr[i][j]);
					}
					for(int j=1;j<=max;j++) {
						if(rCnt[j] != 0) {
							queue.offer(new Point(j,rCnt[j]));
						}
					}
					int cnt = 0;
					while (!queue.isEmpty() && cnt < 100) {
						Point poll = queue.poll();
						arr[i][cnt++] = poll.x;
						arr[i][cnt++] = poll.y;
					}
					tmp = Math.max(tmp, cnt);
					for (; cnt < 100; cnt++) {
						arr[i][cnt] = 0;
					}
					while(!queue.isEmpty()) {
						queue.poll();
					}
				}
				m = tmp;
			}
			// c연산
			else {
				int tmp = -1;
				for (int j = 0; j < m; j++) {
					int[] cCnt = new int[101];
					int max = -1;
					for (int i = 0; i < n; i++) {
						cCnt[arr[i][j]]++;
						max = Math.max(max,arr[i][j]);
					}
					for(int i=1;i<=max;i++) {
						if(cCnt[i]!=0) {
							queue.offer(new Point(i,cCnt[i]));
						}
					}
					int cnt = 0;
					while (!queue.isEmpty() && cnt < 100) {
						Point poll = queue.poll();
						arr[cnt++][j] = poll.x;
						arr[cnt++][j] = poll.y;
					}
					tmp = Math.max(tmp, cnt);
					for (; cnt < 100; cnt++) {
						arr[cnt][j] = 0;
					}
					while(!queue.isEmpty()) {
						queue.poll();
					}
				}
				n = tmp;
			}
			time++;
		}
		System.out.println(time == 101 ? -1 : time);
	}

	static class Point implements Comparable<Point> {
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			int comp = Integer.compare(this.y, o.y);
			return comp == 0 ? Integer.compare(this.x,o.x) : comp;
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
