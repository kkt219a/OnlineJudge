package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15624 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int a=0, b=1, c=1;
		for (int i = 2; i <= n;i++) {
			c = (a+b) % 1_000_000_007;
			a = b;
			b = c;
		}
		System.out.println(n==0?0:c);
	}
}
