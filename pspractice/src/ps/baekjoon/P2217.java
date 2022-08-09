package ps.baekjoon;

import java.util.Arrays;

// 2022/08/09 5분
public class P2217 {
	static int n, max = -1, w = 0, k = 0;
	static int[] a;

	public static void main(String[] args) throws Exception {
		n = read();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = read();
		}
		Arrays.sort(a);
		for (int i = a.length - 1; i >= 0; i--) {
			k++;
			w = a[i] * k;
			max = Math.max(max, w);
		}
		System.out.println(max);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
