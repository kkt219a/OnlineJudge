package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/01 16:00 ~ 16:44, 해설참조
public class P1300 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int left = 1, right = k;
		while(left<right) {
			int mid = (left+right)/2;
			int cnt = 0;
			for(int i=1;i<=n;i++) {
				cnt += Math.min(mid/i,n);
			}
			if(cnt<k) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		System.out.println(left);
	}
}
