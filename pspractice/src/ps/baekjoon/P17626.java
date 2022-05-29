package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/05/30 01:32 ~ 01:48 = 16분
public class P17626 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr = new int[50_001];

	public static void main(String[] args) throws IOException {
		for (int i = 1; i < 50_001; i++) {
			arr[i] = Math.sqrt(i) - (int)Math.sqrt(i) == 0 ? 1 : Integer.MAX_VALUE;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				arr[i] = Math.min(arr[i], arr[j * j] + arr[i - (j * j)]);
			}
		}
		System.out.println(arr[Integer.parseInt(br.readLine())]);
	}
}
