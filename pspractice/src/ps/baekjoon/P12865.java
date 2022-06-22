package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/06/23 해설
public class P12865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] w, v;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		w = new int[n+1];
		v = new int[n+1];
		dp = new int [n+1][k+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k;j++) {
				if(j-w[i] < 0) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j-w[i]]+v[i],dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
