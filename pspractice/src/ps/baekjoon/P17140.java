package ps.baekjoon;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// 2022/07/31 17:51 ~ 18:32/ 20:14 ~ 20:33 / xx:xx = xx분
public class P17140 {
	static int r,c,k,n=3,m=3,time=0;
	static int[][] arr = new int[100][100];

	public static void main(String[] args) throws Exception {
		// 최초 n,m은 3으로 잡자. r과 c가 n과 m보다 작거나 같지 않으면 무시하자.
		r = read()-1;
		c = read()-1;
		k = read();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j] = read();
			}
		}

		while(time<101 && arr[r][c] != k) {
			// r연산
			if(n>=m) {
				for(int i=0;i<100;i++) {
					Map<Integer, Integer> map = new HashMap<>();
					for(int j=0;j<100;j++) {
						if(arr[i][j] != 0) {
							map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
						}
					}
					Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt((Point o) -> o.y).thenComparingInt(o -> o.x));
					for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
						queue.offer(new Point(entry.getKey(), entry.getValue()));
					}
					int cnt = 0;
					while(!queue.isEmpty() && cnt<100) {
						Point poll = queue.poll();
						arr[i][cnt++] = poll.x;
						arr[i][cnt++] = poll.y;
;					}
					m = Math.max(cnt,m);
					for(;cnt<100&&arr[i][cnt]!=0;cnt++) {
						arr[i][cnt] = 0;
					}
				}
			}
			// c연산
			else if(n<m) {
				for(int j=0;j<100;j++) {
					Map<Integer, Integer> map = new HashMap<>();
					for(int i=0;i<100;i++) {
						if(arr[i][j]!=0) {
							map.put(arr[i][j], map.getOrDefault(arr[i][j], 0) + 1);
						}
					}
					Queue<Point> queue = new PriorityQueue<>(Comparator.comparingInt((Point o) -> o.y).thenComparingInt(o -> o.x));
					for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
						queue.offer(new Point(entry.getKey(), entry.getValue()));
					}
					int cnt = 0;
					while(!queue.isEmpty() && cnt<100) {
						Point poll = queue.poll();
						arr[cnt++][j] = poll.x;
						arr[cnt++][j] = poll.y;
					}
					n = Math.max(cnt,n);
					for(;cnt<100&&arr[cnt][j]!=0;cnt++) {
						arr[cnt][j] = 0;
					}
				}
			}
			System.out.println(n+" "+m);
			time++;
		}
		System.out.println(time == 101 ? -1 : time);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
