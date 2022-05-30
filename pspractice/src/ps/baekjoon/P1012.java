package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/05/30 17:48 ~ 18:00 = 12분
public class P1012 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int m;
	static int k;
	static boolean[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String[] infos = br.readLine().split(" ");
			n = Integer.parseInt(infos[0]);
			m = Integer.parseInt(infos[1]);
			k = Integer.parseInt(infos[2]);
			map = new boolean[n][m];
			visited = new boolean[n][m];
			for (int j = 0; j < k; j++) {
				String[] infos2 = br.readLine().split(" ");
				map[Integer.parseInt(infos2[0])][Integer.parseInt(infos2[1])] = true;
			}
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (!visited[j][k] && map[j][k]) {
						dfs(j, k);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		for (int a = 0; a < 4; a++) {
			if (x + dx[a] >= 0 && x + dx[a] < n && y + dy[a] >= 0 && y + dy[a] < m && !visited[x + dx[a]][y + dy[a]]
				&& map[x + dx[a]][y + dy[a]]) {
				dfs(x + dx[a], y + dy[a]);
			}
		}
	}
}
