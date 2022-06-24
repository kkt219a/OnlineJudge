package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/24 17:29 ~ 16:31 = 58분 ,다시
public class P3067 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] dp, arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while (t != 0) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			m = Integer.parseInt(br.readLine());
			dp = new int[m + 1];
			dp[0] = 1;
			for (int i = 0; i < n; i++) {
				for (int j = arr[i]; j <= m; j++) {
					dp[j] += dp[j - arr[i]];
				}
			}
			sb.append(dp[m]).append("\n");
			t--;
		}
		System.out.println(sb);
	}
}
