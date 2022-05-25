package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 조금 더 빠름
public class P10815V2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		br.readLine();
		Set<Integer> ns = Arrays.stream(br.readLine().split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toSet());
		br.readLine();
		List<Integer> ms = Arrays.stream(br.readLine().split(" "))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		for (Integer m : ms) {
			sb.append(ns.contains(m) ? 1 : 0).append(" ");
		}
		System.out.println(sb.toString());
	}
}
