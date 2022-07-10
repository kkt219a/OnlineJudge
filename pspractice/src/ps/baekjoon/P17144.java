package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/07/11 03:32 ~ 04:15 = 43분
public class P17144 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int r, c, t, endX;
	static int[][] original;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		newToken();
		r = parseIntSt();
		c = parseIntSt();
		t = parseIntSt();
		original = new int[r][c];
		for (int i = 0; i < r; i++) {
			newToken();
			for (int j = 0; j < c; j++) {
				original[i][j] = parseIntSt();
				if (original[i][j] == -1) {
					endX = i;
				}
			}
		}
		while (t-- > 0) {
			int[][] copy = new int[r][c];
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (original[i][j] > 0) { // 미세먼지가 존재
						int cnt = 0;
						for (int k = 0; k < 4; k++) {
							int newX = i + dx[k], newY = j + dy[k];
							if (newX >= 0 && newX < r && newY >= 0 && newY < c && original[newX][newY] != -1) {
								copy[newX][newY] += original[i][j] / 5;
								cnt++;
							}
						}
						copy[i][j] += original[i][j] - ((original[i][j] / 5) * cnt);
					}
				}
			}
			original = execute(copy);
			original[endX - 1][0] = original[endX][0] = -1;
		}
		int sum = 0;
		for (int[] o : original) {
			for (int i : o) {
				sum += i;
			}
		}
		System.out.println(sum + 2);
	}

	private static int[][] execute(int[][] copy) {
		int prev = 0;
		for (int i = 1; i < c; i++) {
			int tmp = copy[endX - 1][i];
			copy[endX - 1][i] = prev;
			prev = tmp;
		}
		for (int i = endX - 2; i >= 0; i--) {
			int tmp = copy[i][c - 1];
			copy[i][c - 1] = prev;
			prev = tmp;
		}
		for (int i = c - 2; i >= 0; i--) {
			int tmp = copy[0][i];
			copy[0][i] = prev;
			prev = tmp;
		}
		for (int i = 1; i < endX - 1; i++) {
			int tmp = copy[i][0];
			copy[i][0] = prev;
			prev = tmp;
		}
		prev = 0;
		for (int i = 1; i < c; i++) {
			int tmp = copy[endX][i];
			copy[endX][i] = prev;
			prev = tmp;
		}
		for (int i = endX + 1; i < r; i++) {
			int tmp = copy[i][c - 1];
			copy[i][c - 1] = prev;
			prev = tmp;
		}
		for (int i = c - 2; i >= 0; i--) {
			int tmp = copy[r - 1][i];
			copy[r - 1][i] = prev;
			prev = tmp;
		}
		for (int i = r - 2; i > endX; i--) {
			int tmp = copy[i][0];
			copy[i][0] = prev;
			prev = tmp;
		}
		return copy;
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
