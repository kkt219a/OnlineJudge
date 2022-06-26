package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/26 17:44 ~ 18:20 = 36분
public class P14891 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[][] wheel = new boolean[4][8]; // true: S, false: N
	static int[] rotate;

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 4; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				wheel[i][j] = chars[j] != '0';
			}
		}
		int k = parseIntBr();
		for (int i = 0; i < k; i++) {
			rotate = new int[4];
			newToken();
			int a = parseIntSt() - 1;
			int b = parseIntSt(); // -1: 반시계, 0:비회전, 1: 시계
			rotate[a] = b;
			for (int j = a - 1; j >= 0; j--) {
				if (wheel[j][2] != wheel[j + 1][6]) {
					b = -b;
					rotate[j] = b;
				} else {
					break;
				}
			}
			b = rotate[a];
			for (int j = a + 1; j < 4; j++) {
				if (wheel[j][6] != wheel[j - 1][2]) {
					b = -b;
					rotate[j] = b;
				} else {
					break;
				}
			}
			realRotate(rotate);
		}
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += wheel[i][0] ? Math.pow(2, i) : 0;
		}
		System.out.println(sum);
	}

	private static void realRotate(int[] rotate) {
		for (int i = 0; i < 4; i++) {
			if (rotate[i] == -1) { // 반시계
				boolean prev = wheel[i][0];
				boolean temp;
				for (int j = 7; j >= 0; j--) {
					temp = wheel[i][j];
					wheel[i][j] = prev;
					prev = temp;
				}
			} else if (rotate[i] == 1) { // 시계
				boolean prev = wheel[i][0];
				boolean temp;
				for (int j = 1; j < 8; j++) {
					temp = wheel[i][j];
					wheel[i][j] = prev;
					prev = temp;
				}
				wheel[i][0] = prev;
			}
		}
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
