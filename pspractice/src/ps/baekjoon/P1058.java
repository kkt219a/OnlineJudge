package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/05/30 01:54 ~ 02:34 = 40분
public class P1058 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[][] map;
	static int ans;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		map = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String[] booleans = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = booleans[j].equals("Y");
			}
		}
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (map[i][j]) {
					cnt++;
				} else if (i != j) {
					for (int k = 0; k < n; k++) {
						if (map[i][k] && map[j][k]) {
							cnt++;
							break;
						}
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
