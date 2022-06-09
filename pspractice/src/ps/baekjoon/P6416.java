package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 2022/06/09 10:49 ~ 11:10
public class P6416 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Set<Integer> takeSet = new HashSet<>();
	static Set<Integer> allSet = new HashSet<>();

	public static void main(String[] args) throws IOException {
		int t = 1;
		while (true) {
			while (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine());
			}
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start == -1 && end == -1) {
				break;
			}
			boolean fail = false;
			allSet = new HashSet<>();
			takeSet = new HashSet<>();
			while (start != 0 && end != 0) {
				allSet.add(start);
				allSet.add(end);
				if (takeSet.contains(end)) {
					fail = true;
				} else {
					takeSet.add(end);
				}
				while (!st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
			}
			boolean not = takeSet.size() != allSet.size() - 1 || fail;
			System.out.println("Case " + (t++) + " is " + (not && !allSet.isEmpty() ? "not " : "") + "a tree.");
		}
	}
}
