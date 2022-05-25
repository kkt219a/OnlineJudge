package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// 2022/05/25 22:00 ~ 22:07 = 7분
public class P10815 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		br.readLine();
		List<Integer> ns = Arrays.stream(br.readLine().split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		br.readLine();
		List<Integer> ms = Arrays.stream(br.readLine().split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		Collections.sort(ns);
		for (Integer m : ms) {
			sb.append(Collections.binarySearch(ns,m) < 0 ? 0 : 1).append(" ");
		}
		System.out.println(sb.toString());
	}
}
