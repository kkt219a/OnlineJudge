package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/06/08 10:01 ~ 10:07 = 6분
public class P2003 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int start = 0, end = 0, tempSum = 0, cnt = 0;
		while (start < n) {
			if (tempSum >= m || end == n) {
				tempSum -= arr[start++];
			} else {
				tempSum += arr[end++];
			}
			if (tempSum == m) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
