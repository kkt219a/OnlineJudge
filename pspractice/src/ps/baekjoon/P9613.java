package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/06/10 10:20 ~ 10:30 = 10분
public class P9613 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int j=0;j<n;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			long gcdSum = 0;
			for(int j=0;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					gcdSum += gcd(arr[j],arr[k]);
				}
			}
			System.out.println(gcdSum);
		}
	}

	private static int gcd(int a, int b) {
		if(a==0) {
			return b;
		}
		return gcd(b%a, a);
	}
}
