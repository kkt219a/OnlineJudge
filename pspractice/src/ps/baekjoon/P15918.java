package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/06/04 17:29 ~ 17:07 = 38분
public class P15918 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, x, y;
	static int[] arr;
	static boolean[] visited;
	static int ans;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		arr = new int[2 * n];
		visited = new boolean[n];
		int num = Math.abs(x - y) - 1;
		arr[x - 1] = num;
		arr[y - 1] = num;
		visited[num - 1] = true;
		dfs(1, 0);
		System.out.println(ans);
	}

	private static void dfs(int depth, int idx) {
		if (depth == n) {
			ans++;
		} else if (arr[idx] == 0) {
			for (int j = 1; j <= n; j++) { // 해당 자리에 1~n까지 숫자 넣어보기
				// 해당하는 숫자를 사용한 적이 없어야하고, 랭퍼드 수열에 두 자리가 다 비어 있어야 진행 가능
				if (!visited[j - 1] && idx + j + 1 < 2 * n && arr[idx] == 0 && arr[idx + j + 1] == 0) {
					arr[idx] = j;
					arr[idx + j + 1] = j;
					visited[j - 1] = true;
					dfs(depth + 1, idx + 1);
					arr[idx] = 0;
					arr[idx + j + 1] = 0;
					visited[j - 1] = false;
				}
			}
		} else {
			dfs(depth, idx + 1);
		}
	}
}
