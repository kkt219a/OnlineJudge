package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 2022/06/10 12:56 ~ 01:36 = 40분
public class P7682 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		char[] pos = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
		String inp;
		dfs(10, pos);
		while (!(inp = br.readLine()).equals("end")) {
			sb.append(set.contains(inp) ? "valid" : "invalid").append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int num, char[] chars) {
		boolean next = true;
		if (num <= 5) {
			if (isFinish(chars) || num == 1) {
				set.add(String.valueOf(chars));
				next = false;
			}
		}
		if (next) {
			for (int i = 0; i < 9; i++) {
				if (chars[i] == '.') {
					chars[i] = num % 2 == 0 ? 'X' : 'O';
					dfs(num - 1, chars);
					chars[i] = '.';
				}
			}
		}
	}

	private static boolean isFinish(char[] c) {
		if (c[0] != '.' && c[0] == c[1] && c[1] == c[2]) {
			return true;
		} else if (c[3] != '.' && c[3] == c[4] && c[4] == c[5]) {
			return true;
		} else if (c[6] != '.' && c[6] == c[7] && c[7] == c[8]) {
			return true;
		} else if (c[0] != '.' && c[0] == c[3] && c[3] == c[6]) {
			return true;
		} else if (c[1] != '.' && c[1] == c[4] && c[4] == c[7]) {
			return true;
		} else if (c[2] != '.' && c[2] == c[5] && c[5] == c[8]) {
			return true;
		} else if (c[0] != '.' && c[0] == c[4] && c[4] == c[8]) {
			return true;
		} else
			return c[2] != '.' && c[2] == c[4] && c[4] == c[6];
	}

}
