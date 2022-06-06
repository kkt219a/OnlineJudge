package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 2022/06/06 10:57 ~ 11:17 = 20분
public class P15961 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] arr;
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int ans = -1;
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int start = 0, end = k - 1;
		arr = new int[n];
		map.put(c, 1);
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (i <= end) {
				map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			}
		}
		while (start < n) {
			end = end == n - 1 ? 0 : end + 1;
			ans = Math.max(ans, map.size());
			Integer sv = map.get(arr[start]);
			if (sv > 1) {
				map.put(arr[start], sv - 1);
			} else {
				map.remove(arr[start]);
			}
			map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
			start++;
		}
		System.out.println(ans);
	}
}
