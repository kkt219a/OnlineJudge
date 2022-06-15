package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/06/15 10:48 ~ 11:04 = 16분
public class P9372 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,m;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			for(int j=0;j<m;j++) {
				br.readLine();
			}
			sb.append(n-1).append("\n");
		}
		System.out.println(sb);
	}
}
