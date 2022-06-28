package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/28 20:01 ~ 20:21 = 20분
public class P11054 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] dp1, dp2, arr;
	static int sum = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		int n = parseIntBr();
		dp1 = new int[n + 1];
		dp2 = new int[n + 1];
		arr = new int[n + 1];
		newToken();
		for (int i = 1; i <= n; i++) {
			arr[i] = parseIntSt();
			dp1[i] = 1;
			for (int j = i - 1; j >= 1; j--) {
				if (arr[j] < arr[i]) {
					dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
				}
			}
		}
		for (int i = n; i >= 1; i--) {
			dp2[i] = 1;
			for (int j = i + 1; j <= n; j++) {
				if (arr[j] < arr[i]) {
					dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
				}
			}
			sum = Math.max(sum, dp1[i] + dp2[i]-1);
		}
		System.out.println(sum);

	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
