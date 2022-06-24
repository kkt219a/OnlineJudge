package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// 2022/06/24 16:35 ~ 16:48 = 13분
public class P15970 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Map<Integer, List<Integer>> lines = new HashMap<>();
	static int totalSum;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int spot = Integer.parseInt(st.nextToken());
			int color = Integer.parseInt(st.nextToken());
			List<Integer> lists = lines.getOrDefault(color, new ArrayList<>());
			lists.add(spot);
			lines.put(color, lists);
		}
		for (List<Integer> value : lines.values()) {
			Collections.sort(value);
			int sum = 0;
			for (int i = 0, j = value.size(); i < j; i++) {
				if (i == 0) {
					sum += Math.abs(value.get(1) - value.get(0));
				} else if (i == j - 1) {
					sum += Math.abs(value.get(j - 2) - value.get(j - 1));
				} else {
					sum += Math.min(Math.abs(value.get(i) - value.get(i - 1)),
						Math.abs(value.get(i) - value.get(i + 1)));
				}
			}
			totalSum += sum;
		}
		System.out.println(totalSum);
	}
}
