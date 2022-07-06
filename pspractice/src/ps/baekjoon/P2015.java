package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 2022/07/06 참조
public class P2015 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] a;
	static Map<Integer, Long> aMap = new HashMap<>();
	static long cnt;

	public static void main(String[] args) throws IOException {
		newToken();
		int n = parseIntSt();
		int k = parseIntSt();
		a = new int[n + 1];
		newToken();
		for (int i = 1; i <= n; i++) {
			a[i] = parseIntSt() + a[i - 1];
			if (a[i] == k) {
				cnt++;
			}
			cnt += aMap.getOrDefault(a[i] - k, 0L);
			aMap.put(a[i], aMap.getOrDefault(a[i], 0L) + 1);
		}
		System.out.println(cnt);
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
