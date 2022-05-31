package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022/05/31 15:26 ~ 15:30 = 4분
public class P5347 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int[] v = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int gcd = gcd(Math.min(v[0], v[1]), Math.max(v[0], v[1]));
			System.out.println((v[0] / gcd) * (v[1] / gcd) * gcd);
		}
	}

	private static int gcd(int a, int b) {
		if (a == 0) {
			return b;
		} else {
			return gcd(b % a, a);
		}
	}
}
