package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022/05/29 18:05 ~ 18:24 = 19분
public class P1182 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] nums;
	static boolean[] visited;
	static int cnt;
	static int sum;

	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().split(" ");
		sum = Integer.parseInt(s[1]);
		nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		visited = new boolean[nums.length];
		dfs(0, -1, 0);
		System.out.println(cnt);
	}

	private static void dfs(int tempSum, int start, int depth) {
		if (tempSum == sum && depth != 0) {
			cnt++;
		}
		if (depth != nums.length) {
			for (int i = start + 1; i < nums.length; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(tempSum + nums[i], i, depth + 1);
					visited[i] = false;
				}
			}
		}
	}
}
