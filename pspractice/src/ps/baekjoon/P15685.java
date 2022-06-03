package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/03 17:51 ~ 18:39 = 48분
public class P15685 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map = new int[101][101];
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			int g = Integer.parseInt(st.nextToken());
			String path = getPath(d, g);
			draw(x, y, path);
		}
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}

	private static void draw(int x, int y, String path) {
		map[x][y] = 1;
		char[] chars = path.toCharArray();
		for (char aChar : chars) {
			int v = aChar - '0';
			map[x + dx[v]][y + dy[v]] = 1;
			x += dx[v];
			y += dy[v];
		}
	}

	private static String getPath(String d, int g) {
		StringBuilder sb = new StringBuilder(d);
		int now = 0;
		while (g != now) {
			now++;
			sb.append(nextV(sb.toString()));
		}
		return sb.toString();
	}

	private static String nextV(String v) {
		StringBuilder sb = new StringBuilder();
		char[] chars = v.toCharArray();
		for (char aChar : chars) {
			int vv = aChar - '0';
			sb.append(vv == 3 ? 0 : vv + 1);
		}
		return sb.reverse().toString();
	}
}
