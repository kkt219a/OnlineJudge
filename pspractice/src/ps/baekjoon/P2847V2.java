package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쉬운 sol
public class P2847V2 {
	static int[] arr = new int[100];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i= t-2;i>=0;i--) {
			if(arr[i]>=arr[i+1]) {
				int cnt = arr[i]-arr[i+1]+1;
				ans += cnt;
				arr[i] -= cnt;
			}
		}
		System.out.println(ans);
	}
}
