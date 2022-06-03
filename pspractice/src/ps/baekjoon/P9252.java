package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/06/03 19:04~ 해설 참조
public class P9252 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[] a, b;
	static int i, j;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		a = br.readLine().toCharArray();
		b = br.readLine().toCharArray();
		dp = new int[a.length + 1][b.length + 1];
		int nowV = 0;
		for (i = 1; i < dp.length; i++) {
			for (j = 1; j < dp[i].length; j++) {
				dp[i][j] = a[i - 1] == b[j - 1] ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		i--;
		j--;
		while(i>0 && j>0) {
			if(dp[i][j]==dp[i-1][j]) {
				i--;
			} else if(dp[i][j]==dp[i][j-1]) {
				j--;
			} else {
				sb.append(a[i-1]);
				i--;
				j--;
			}
		}
		System.out.println(dp[a.length][b.length]);
		System.out.println(sb.reverse().toString());
	}
}
