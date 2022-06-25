package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/25 15:36 ~ 16:10 = 34분
public class P14921 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = parseIntBr();
		int[] arr = new int[n];
		int diff = Integer.MAX_VALUE;
		newToken();
		for (int i = 0; i < n; i++) {
			arr[i] = parseIntSt();
		}
		for (int first = 0, second = n - 1; first < second; ) {
			diff = Math.abs(diff) > Math.abs(arr[first] + arr[second]) ? arr[first] + arr[second] : diff;
			if (Math.abs(arr[first + 1] + arr[second]) < Math.abs(arr[first] + arr[second - 1])) {
				first++;
			} else {
				second--;
			}
		}
		System.out.println(diff);
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
