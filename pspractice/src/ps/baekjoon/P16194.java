package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/05 16:39 ~ 16:59 = 20분
public class P16194 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dp = new int[1001];
	public static void main(String[] args) throws IOException {
		br.readLine();
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i=1;i<=s.length;i++) {
			for(int j=i;j<=s.length;j++) {
				dp[j] = Math.min(dp[j],dp[j-i]+s[i-1]);
			}
		}
		System.out.println(dp[s.length]);
	}
}
