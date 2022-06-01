package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022/06/01
public class P2166 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static long sum1, sum2;
	static long[] x,y;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		x = new long[n+1];
		y = new long[n+1];
		for(int i=0;i<n;i++) {
			long[] a = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
			x[i] = a[0];
			y[i] = a[1];
		}
		x[n] = x[0];
		y[n] = y[0];
		for(int i=0;i<n;i++) {
			sum1 += (x[i] * y[i+1]);
			sum2 += (y[i] * x[i+1]);
		}
		System.out.printf("%.2f%n", Math.abs(sum1-sum2)/2.0);
	}
}
