package ps.baekjoon;

import java.io.*;
import java.util.*;

// 2022/05/25 17:28 ~ 18:05 해설
public class P14925 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int m;
	static int n;
	static boolean[][] arr;
	static int[][] dp;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		String[] mn = br.readLine().split(" ");
		m = Integer.parseInt(mn[0]);
		n = Integer.parseInt(mn[1]);
		arr = new boolean[m][n];
		dp = new int[m+1][n+1];
		for(int i=0;i<m;i++) {
			String[] row = br.readLine().split(" ");
			for(int j=0; j<n;j++) {
				arr[i][j] = row[j].equals("0");
			}
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(arr[i-1][j-1]) {
					dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
					ans = Math.max(dp[i][j],ans);
				}
			}
		}
		System.out.println(ans);
	}
}
