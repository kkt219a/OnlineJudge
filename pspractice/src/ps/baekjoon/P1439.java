package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/06/22 22:00 ~ 22:10 = 10분
public class P1439 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] num = new int[2];

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		for (int i = 0, j = s.length(); i < j; ) {
			char start = s.charAt(i);
			while (i < j && start == s.charAt(i)) {
				i++;
			}
			num[start - '0']++;
		}
		System.out.println(Math.min(num[0], num[1]));
	}
}
