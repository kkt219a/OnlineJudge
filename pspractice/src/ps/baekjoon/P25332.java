package ps.baekjoon;

import java.util.HashMap;

// 2022/07/06 오래걸림
public class P25332 {
	public static void main(String[] args) throws Exception {
		HashMap<Integer, Long> sumMap = new HashMap<>();
		int n = read();
		int[] a = new int[n + 1], b = new int[n + 1];
		long cnt = 0;
		for (int i = 1; i <= n; i++) {
			a[i] = read() + a[i - 1];
		}
		for (int i = 1; i <= n; i++) {
			b[i] = read() + b[i - 1];
			int v = a[i]-b[i];
			cnt += sumMap.getOrDefault(v,0L);
			sumMap.put(v, sumMap.getOrDefault(v,0L)+1);
			cnt += v == 0 ? 1 : 0;
		}
		System.out.println(cnt);
	}
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
