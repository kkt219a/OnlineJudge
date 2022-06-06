package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 2022/06/06 11:17 ~ 11:35 = 18분
public class P15961V2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static int[] ate;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int ans = 0;
		int tempAns = 1;
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int start = 0, end = k - 1;
		arr = new int[n];
		ate = new int[d+1];
		ate[c] = 1;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i <= end) {
				ate[arr[i]]++;
				if(ate[arr[i]] == 1) {
					tempAns++;
				}
			}
		}
		while (start < n) {
			ate[arr[start]]--;
			if(ate[arr[start]] == 0) {
				tempAns--;
			}
			end++;
			if(ate[arr[end%n]] == 0) {
				tempAns++;
			}
			ate[arr[end%n]]++;
			ans = Math.max(ans, tempAns);
			start++;
		}
		System.out.println(ans);
	}
}
