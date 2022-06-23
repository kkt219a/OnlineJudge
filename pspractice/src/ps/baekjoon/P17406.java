package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/23 15:40 ~ 16:35 = 55분
public class P17406 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr;
	static int n, m, k;
	static int[] r, c, s;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
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
		dfs(0,arr);
		System.out.println(min);
	}

	static void dfs(int depth, int[][] arr) {
		if(depth == k) {
			for (int[] ar : arr) {
				int sum = Arrays.stream(ar).sum();
				min = Math.min(min, sum);
			}
		} else {
			for (int i = 0; i < k; i++) {
				if (!visited[i]) {
					visited[i] = true;
					int[][] newArr = rotate(r[i], c[i], s[i], arr);
					dfs(depth + 1, newArr);
					visited[i] = false;
				}
			}
		}
	}

	static int[][] rotate(int r, int c, int s, int[][] arr) {
		int[][] a = new int[n][m];
		for(int i=0;i<n;i++) {
			System.arraycopy(arr[i], 0, a[i], 0, m);
		}
		for (int j = s; j > 0; j--) {
			int prev = a[r - j][c - j];
			int temp;
			for (int i = c - j + 1; i <= c + j; i++) {
				temp = a[r - j][i];
				a[r - j][i] = prev;
				prev = temp;
			}
			for (int i = r - j + 1; i <= r + j; i++) {
				temp = a[i][c + j];
				a[i][c + j] = prev;
				prev = temp;
			}
			for (int i = c + j - 1; i >= c - j; i--) {
				temp = a[r + j][i];
				a[r + j][i] = prev;
				prev = temp;
			}
			for (int i = r + j - 1; i >= r - j; i--) {
				temp = a[i][c - j];
				a[i][c - j] = prev;
				prev = temp;
			}
		}
		return a;
	}
}
