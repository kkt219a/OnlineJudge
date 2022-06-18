package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// DFS 풀이
// 2022/06/17 17:31 ~ 17:48 = 17분
public class P17484 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static boolean[][] visited;
	static int minV = Integer.MAX_VALUE;
	static int n,m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for(int i=0;i<m;i++) {
			dfs(0, i, -2, 0);
		}
		System.out.println(minV);
	}

	private static void dfs(int x, int y, int lastDir, int cost) {
		if(x==n-1) {
			minV = Math.min(minV, cost+map[x][y]);
		} else {
			// 좌측
			if(lastDir != -1 && y-1>=0) {
				dfs(x+1,y-1,-1, cost+map[x][y]);
			}
			// 중앙
			if(lastDir != 0) {
				dfs(x+1,y,0, cost+map[x][y]);
			}
			// 우측
			if(lastDir != 1 && y+1<m) {
				dfs(x+1,y+1,1, cost+map[x][y]);
			}
		}
	}
}
