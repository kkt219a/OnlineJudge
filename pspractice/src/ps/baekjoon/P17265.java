package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/05/30 19:14 ~ 19:34 = 20분
public class P17265 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String[][] map;
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new String[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().split(" ");
		}
		dfs(0, 0, 0, "+");
		System.out.println(max + " " + min);
	}

	private static void dfs(int x, int y, int sum, String lastExp) {
		if (x == n - 1 && y == n - 1) {
			sum = calc(sum, lastExp, Integer.parseInt(map[x][y]));
			min = Math.min(min, sum);
			max = Math.max(max, sum);
		} else {
			if (x < n && y < n) {
				if (lastExp == null) {
					dfs(x + 1, y, sum, map[x][y]);
					dfs(x, y + 1, sum, map[x][y]);
				} else {
					dfs(x + 1, y, calc(sum, lastExp, Integer.parseInt(map[x][y])), null);
					dfs(x, y + 1, calc(sum, lastExp, Integer.parseInt(map[x][y])), null);
				}
			}
		}
	}

	private static int calc(int sum, String lastExp, int value) {
		if (lastExp.equals("-")) {
			return sum - value;
		} else if (lastExp.equals("+")) {
			return sum + value;
		} else {
			return sum * value;
		}
	}
}
