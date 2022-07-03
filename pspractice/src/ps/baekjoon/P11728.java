package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11728 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		newToken();
		int n = parseIntSt();
		int m = parseIntSt();
		arr = new int[n+m];
		newToken();
		for(int i=0;i<n+m;i++) {
			if(i==n) {
				newToken();
			}
			arr[i] = parseIntSt();
		}
		Arrays.sort(arr);
		for (int i : arr) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
