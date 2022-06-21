package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022/06/22 01:43 ~ xx:xx = xx분
public class P11508 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] prices;
	static int n;
	static int sum;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		prices = new int[n];
		for (int i = 0; i < n; i++) {
			prices[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(prices);
		int i = n-1;
		for (; i - 2 >= 0; i -= 3) {
			sum += prices[i] + prices[i - 1];
		}
		for (; i >= 0; i--) {
			sum += prices[i];
		}
		System.out.println(sum);
		// 2 3 4 4 6 9 10
		// 19 + 8 + 2
	}
}
