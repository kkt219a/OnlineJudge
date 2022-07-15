package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 2022/07/14 16:11 ~ 17:20 = 69분
public class P4195 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int f, cnt;
	static Map<String, Integer> names;
	static Map<Integer, Integer> counts;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		for (int t = parseIntBr(); t > 0; t--) {
			f = parseIntBr();
			names = new HashMap<>();
			counts = new HashMap<>();
			parents = new int[f * 2];
			for (int i = 0; i < parents.length; i++) {
				parents[i] = i;
				counts.put(i, 1);
			}
			cnt = 0;
			for (int i = 0; i < f; i++) {
				newToken();
				String fr1 = st.nextToken();
				String fr2 = st.nextToken();
				int one = names.getOrDefault(fr1, cnt);
				if(one == cnt) {
					names.put(fr1, cnt++);
				}
				int two = names.getOrDefault(fr2, cnt);
				if(two == cnt) {
					names.put(fr2, cnt++);
				}
				int v = union(one, two);
				sb.append(counts.get(v)).append("\n");
			}
		}
		System.out.println(sb);
	}

	private static int union(int one, int two) {
		int oneParent = find(one);
		int twoParent = find(two);
		if (oneParent < twoParent) {
			parents[twoParent] = oneParent;
			counts.put(oneParent, counts.get(oneParent) + counts.get(twoParent));
			return oneParent;
		} else if (oneParent > twoParent) {
			parents[oneParent] = twoParent;
			counts.put(twoParent, counts.get(oneParent) + counts.get(twoParent));
			return twoParent;
		}
		return oneParent;
	}

	private static int find(int val) {
		if (parents[val] != val) {
			return parents[val] = find(parents[val]);
		}
		return val;
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
