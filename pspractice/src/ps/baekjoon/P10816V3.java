package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022/06/05 16:16 ~ 16:21 = 5분, BS가 더 느림
public class P10816V3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] s;

	public static void main(String[] args) throws IOException {
		br.readLine();
		s = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		Arrays.sort(s);
		br.readLine();
		int[] s1 = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		for (int i : s1) {
			sb.append(bs_upper(i)-bs_lower(i)).append(" ");
		}
		System.out.println(sb);
	}

	private static int bs_upper(int search) {
		int left = 0, right = s.length;
		while(left<right) {
			int mid = (left+right) /2;
			if(search < s[mid]) {
				right = mid;
			} else {
				left = mid+1;
			}
		}
		return left;
	}

	private static int bs_lower(int search) {
		int left = 0, right = s.length;
		while(left<right) {
			int mid = (left+right) /2;
			if(search <= s[mid]) {
				right = mid;
			} else {
				left = mid+1;
			}
		}
		return left;
	}
}
