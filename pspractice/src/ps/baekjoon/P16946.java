package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// 2022/07/18 16:39 ~ xx:xx = xx분
public class P16946 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;
	static boolean[][] map;
	static boolean[][] visited;
	static int[][] area;
	static int[][] separator;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		m = parseIntSt();
		map = new boolean[n][m];
		visited = new boolean[n][m];
		area = new int[n][m];
		separator = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) == '0';
			}
		}
		int id = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] && !visited[i][j]) {
					bfs(id, i, j);
					id++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!map[i][j]) {
					int cnt = 1;
					Set<Integer> ids = new HashSet<>();
					for(int p=0;p<4;p++) {
						int newX = i+dx[p], newY = j+dy[p];
						if (newX >= 0 && newY >= 0 && newX < n && newY < m && map[newX][newY]&& !ids.contains(separator[newX][newY])) {
							cnt += area[newX][newY];
							ids.add(separator[newX][newY]);
						}
					}
					sb.append(cnt % 10);
				} else {
					sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int id, int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		List<int[]> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			list.add(poll);
			for (int i = 0; i < 4; i++) {
				int newX = poll[0] + dx[i], newY = poll[1] + dy[i];
				if (newX >= 0 && newY >= 0 && newX < n && newY < m && map[newX][newY] && !visited[newX][newY]) {
					visited[newX][newY] = true;
					queue.offer(new int[] {newX, newY});
				}
			}
		}
		int size = list.size();
		for (int[] ints : list) {
			area[ints[0]][ints[1]] = size;
			separator[ints[0]][ints[1]] = id;
		}
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
