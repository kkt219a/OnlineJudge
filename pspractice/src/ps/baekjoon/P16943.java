package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// 2022/06/02 17:44 ~ 17:59 = 15분
public class P16943 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] a;
	static Set<Integer> aSet = new HashSet<>();
	static boolean[] visited;
	static int b;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		a = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
		visited = new boolean[a.length];
		b = Integer.parseInt(st.nextToken());
		dfs(0,"");
		aSet.removeIf(a -> a>=b);
		System.out.println(aSet.stream().max(Integer::compareTo).orElse(-1));
	}

	private static void dfs(int depth, String sen) {
		if(depth==a.length) {
			aSet.add(Integer.parseInt(sen));
		} else if(!sen.startsWith("0")) {
			for (int i = 0; i < a.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(depth + 1, sen + a[i]);
					visited[i] = false;
				}
			}
		}
	}

}
