package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/25 16:31 ~ 16:46 = 15분
public class P15723 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static boolean[][] arr = new boolean[26][26];

	public static void main(String[] args) throws IOException {
		int n = parseIntBr();
		for (int i = 0; i < n; i++) {
			newToken();
			int a = st.nextToken().charAt(0) - 97;
			st.nextToken();
			int b = st.nextToken().charAt(0) - 97;
			arr[a][b] = true;
		}
		for (int mid = 0; mid < 26; mid++) {
			for (int start = 0; start < 26; start++) {
				for (int end = 0; end < 26; end++) {
					if (!(start == end && end == mid) && arr[start][mid] && arr[mid][end]) {
						arr[start][end] = true;
					}
				}
			}
		}
		int m = parseIntBr();
		for (int i = 0; i < m; i++) {
			newToken();
			int a = st.nextToken().charAt(0) - 97;
			st.nextToken();
			int b = st.nextToken().charAt(0) - 97;
			sb.append(arr[a][b] ? 'T' : 'F').append("\n");
		}
		System.out.println(sb);
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
