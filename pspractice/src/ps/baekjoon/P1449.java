package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/04 16:39 ~ 16:59 = 20분
public class P1449 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, l;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).distinct().toArray();
		Arrays.sort(arr);
		int count = 0;
		for (int i = 0; i < arr.length; ) {
			int j = i + 1;
			while (j < arr.length && arr[j] - arr[i] <= l - 1) {
				j++;
			}
			i = j;
			count++;
		}
		System.out.println(count);
	}
}
