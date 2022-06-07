package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/07 14:41~ 해설참조
public class P1507 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] map;
	static boolean[][] removeBridge;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		removeBridge = new boolean[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int mid=1;mid<=n;mid++) {
			for(int start=1;start<=n;start++) {
				for(int end=1;end<=n;end++) {
					if(start==mid||mid==end||start==end) {
						continue;
					}
					if(map[start][end] == map[start][mid]+map[mid][end]) {
						removeBridge[start][end] = true;
					} else if(map[start][end] > map[start][mid]+map[mid][end]) {
						System.out.println("-1");
						System.exit(0);
					}
				}
			}
		}
		int sum = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(!removeBridge[i][j]) {
					sum+=map[i][j];
				}
			}
		}
		System.out.println(sum/2);
	}
}
