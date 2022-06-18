package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 2022/06/19 02:30 ~ 02:47 = 17분
public class P16198 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[] weight;
	static boolean[] visited;
	static int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n];
		weight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		dfs(0, 0);
		System.out.println(maxSum);
	}

	private static void dfs(int sum, int depth) {
		if (depth == n - 2) {
			maxSum = Math.max(maxSum, sum);
		} else {
			for (int i = 1; i < n - 1; i++) {
				if (!visited[i]) {
					visited[i] = true;
					int left = i - 1, right = i + 1;
					for (; visited[left]; left--);
					for (; visited[right]; right++);
					dfs(sum + weight[left] * weight[right], depth + 1);
					visited[i] = false;
				}
			}
		}
	}
}
