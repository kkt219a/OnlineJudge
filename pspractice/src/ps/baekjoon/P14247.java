package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/16 15:15 해설 참조
public class P14247 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long[] h, a;

	public static void main(String[] args) throws IOException {
		Queue<Point> queue = new PriorityQueue<>();
		int n = Integer.parseInt(br.readLine());
		h = new long[n];
		a = new long[n];
		st = new StringTokenizer(br.readLine());
		long ret = 0;
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			queue.offer(new Point(h[i], a[i]));
		}
		for (int i = 0; i < n; i++) {
			Point poll = queue.poll();
			ret += poll.h + poll.a * i;
		}
		System.out.println(ret);
	}

	static class Point implements Comparable<Point> {
		long h, a;

		public Point(long h, long a) {
			this.h = h;
			this.a = a;
		}

		@Override
		public int compareTo(Point o) {
			return Long.compare(this.a, o.a);
		}
	}
}
