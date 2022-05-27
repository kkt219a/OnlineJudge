package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/05/27 18:09 ~ 18:20 = 11분
public class P2960 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] primes;

	public static void main(String[] args) throws IOException {
		String[] line = br.readLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		primes = new boolean[n+1];
		for(int i=2;i<=n && k != 0;i++) {
			for(int j=i;j<=n;j+=i) {
				if(!primes[j]) {
					primes[j] = true;
					k--;
				}
				if(k==0) {
					System.out.println(j);
					break;
				}
			}
		}
	}
}
