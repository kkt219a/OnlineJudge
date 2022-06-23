package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 2022/06/23 15:40 ~ 16:35 = 55분
public class P17406V2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr, copy;
	static int n, m, k;
	static int[] r, c, s;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	static List<Integer> seq = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		r = new int[k];
		c = new int[k];
		s = new int[k];
		visited = new boolean[k];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			r[i] = Integer.parseInt(st.nextToken())-1;
			c[i] = Integer.parseInt(st.nextToken())-1;
			s[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0);
		System.out.println(min);
	}

	static void dfs(int depth) {
		if(depth == k) {
			init();
			for(int i=0;i<k;i++) {
				int tk = seq.get(i);
				rotate(r[tk],c[tk],s[tk]);
			}
			for (int[] ar : copy) {
				int sum = Arrays.stream(ar).sum();
				min = Math.min(min, sum);
			}
		} else {
			for (int i = 0; i < k; i++) {
				if (!visited[i]) {
					visited[i] = true;
					seq.add(i);
					dfs(depth + 1);
					seq.remove(Integer.valueOf(i));
					visited[i] = false;
				}
			}
		}
	}

	private static void init() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				copy[i][j] = arr[i][j];
			}
		}
	}

	static void rotate(int r, int c, int s) {
		for (int j = s; j > 0; j--) {
			int prev = copy[r - j][c - j];
			int temp;
			for (int i = c - j + 1; i <= c + j; i++) {
				temp = copy[r - j][i];
				copy[r - j][i] = prev;
				prev = temp;
			}
			for (int i = r - j + 1; i <= r + j; i++) {
				temp = copy[i][c + j];
				copy[i][c + j] = prev;
				prev = temp;
			}
			for (int i = c + j - 1; i >= c - j; i--) {
				temp = copy[r + j][i];
				copy[r + j][i] = prev;
				prev = temp;
			}
			for (int i = r + j - 1; i >= r - j; i--) {
				temp = copy[i][c - j];
				copy[i][c - j] = prev;
				prev = temp;
			}
		}
	}
}
