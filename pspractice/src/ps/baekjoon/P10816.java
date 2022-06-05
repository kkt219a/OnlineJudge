package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 2022/06/05 16:02 ~ 16:05 = 3분
public class P10816 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		br.readLine();
		int[] s = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		for (int i : s) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		br.readLine();
		int[] t = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt).toArray();
		for (int i : t) {
			sb.append(map.getOrDefault(i, 0)).append(" ");
		}
		System.out.println(sb);
	}
}
