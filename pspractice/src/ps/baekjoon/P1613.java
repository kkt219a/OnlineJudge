package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/06 11:40 ~ 12:14 = 34분
public class P1613 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = -1;
		}
		for(int mid=1;mid<=n;mid++) {
			for(int start=1;start<=n;start++) {
				for(int end=1;end<=n;end++) {
					if(map[start][end] == 0) {
						int v = map[start][mid] + map[mid][end];
						map[start][end] = Math.abs(v) == 2 ? v/2 : 0;
					}
				}
			}
		}
		int s = Integer.parseInt(br.readLine());
		for(int i=0;i<s;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			sb.append(map[b][a]).append("\n");
		}
		System.out.println(sb);
	}
}
