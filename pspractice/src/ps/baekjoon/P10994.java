package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/06/07 10:02 ~ 10:38 = 36분
public class P10994 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[][] sen;
	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		sen = new char[4 * n - 3][4 * n - 3];
		for (int i = 0; i < sen.length; i++) {
			for (int j = 0; j < sen.length; j++) {
				sen[i][j] = ' ';
			}
		}
		fun(n, 0, 0);
		for (char[] chars : sen) {
			for (int j = 0; j < sen.length; j++) {
				sb.append(chars[j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void fun(int k, int start, int end) {
		if (k == 1) {
			sen[start][end] = '*';
		} else {
			fun(k - 1, start + 2, end + 2);
			for (int i = 0; i < (4 * k - 3); i++) {
				sen[start][end + i] = '*';
			}
			for (int i = 1; i <= 4 * k - 5; i++) {
				sen[start + i][end] = '*';
				sen[start + i][end + (4 * k - 3) - 1] = '*';
			}
			for (int i = 0; i < (4 * k - 3); i++) {
				sen[start + (4 * k - 3) - 1][end + i] = '*';
			}
		}
	}
}
