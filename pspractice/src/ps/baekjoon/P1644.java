package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 2022/06/05 18:25 ~ 18:59 = 34분
public class P1644 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static boolean[] isNotPrime = new boolean[4_000_001];
	static List<Integer> primes = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		erato();
		for(int i=1;i<4_000_001;i++) {
			if(!isNotPrime[i]) {
				primes.add(i);
			}
		}
		int n  = Integer.parseInt(br.readLine());
		int tempSum = 0;
		int cnt = 0;
		for(int start=0, end = 0; start < primes.size();) {
			if(tempSum >= n || end == primes.size()) {
				tempSum -= primes.get(start++);
			} else {
				tempSum += primes.get(end++);
			}
			if(tempSum == n) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void erato() {
		isNotPrime[1] = true;
		for(int i=2;i*i<4_000_001;i++) {
			if(!isNotPrime[i]) {
				for(int j=i*i;j<4_000_001;j+=i) {
					isNotPrime[j] = true;
				}
			}
		}
	}
}
