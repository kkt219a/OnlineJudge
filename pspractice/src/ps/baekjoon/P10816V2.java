package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022/06/05 16:12 ~ 16:13 = 1분
public class P10816V2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] a = new int[20000001];

	public static void main(String[] args) throws IOException {
		br.readLine();
		Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).forEach(i -> a[i + 10000000]++);
		br.readLine();
		Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).forEach(i -> sb.append(a[i + 10000000]).append(" "));
		System.out.println(sb);
	}
}
