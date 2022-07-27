package ps.baekjoon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// 2022/07/27 19:10 ~ 19:52 = 42분
public class P23288 {
	//반대 방향은 dir+2%4
	static int n, m, k, sum, dir = 2;
	static int[][] map, stack;
	static boolean[][] visited;
	static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0}; // 좌하우상
	// 왼쪽으로 굴리면 side가 왼쪽으로 하나씩 밀린다 오른쪽이면 오른쪽으로 밀린다.
	// 그리고 front의 0,2 인덱스는 side의 0,2 인덱스로 바뀐다.
	// 위로 굴리면 프론트가 왼쪽으로 밀리고 아래로 굴리면 프론트가 오른쪽으로 밀린다.
	// 그리고 side의 0,2 인덱스는
	static int[] front = {1, 5, 6, 2}, side = {1, 3, 6, 4}; // 상앞하뒤, 상오하왼

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		k = read();
		map = new int[n][m];
		stack = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = read();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		// 해당 이동한 칸의 점수 획득(점수는 해당칸 B와 숫자가 같은동안 BFS해서 개수 C를 가져와서 B*C
		// 주사위 아래면(A)과 바닥의 크기(B)를 비교
		// A>B -> dir+3%4, A<B -> dir+1%4, A==B -> 그대로
		int nowX = 0, nowY = 0;
		while (k-- > 0) {
			// 이동하기 전 범위 체크하고 벗어나면 반대로 변경 후 이동
			if (!notExceed(nowX, nowY, dir)) {
				dir = (dir + 2) % 4;
			}
			nowX += dx[dir];
			nowY += dy[dir];
			tumble(dir);
			sum += (stack[nowX][nowY] * map[nowX][nowY]);
			if (front[2] > map[nowX][nowY]) {
				dir = (dir + 3) % 4;
			} else if (front[2] < map[nowX][nowY]) {
				dir = (dir + 1) % 4;
			}
		}
		System.out.println(sum);
	}

	private static void tumble(int dir) {
		if (dir == 0) { // 좌
			for (int i = 0; i < 3; i++) {
				int tmp = side[i];
				side[i] = side[i + 1];
				side[i + 1] = tmp;
			}
			front[0] = side[0];
			front[2] = side[2];
		} else if (dir == 1) { // 하
			for (int i = 3; i >= 1; i--) {
				int tmp = front[i];
				front[i] = front[i - 1];
				front[i - 1] = tmp;
			}
			side[0] = front[0];
			side[2] = front[2];
		} else if (dir == 2) { // 우
			for (int i = 3; i >= 1; i--) {
				int tmp = side[i];
				side[i] = side[i - 1];
				side[i - 1] = tmp;
			}
			front[0] = side[0];
			front[2] = side[2];
		} else if (dir == 3) { // 상
			for (int i = 0; i < 3; i++) {
				int tmp = front[i];
				front[i] = front[i + 1];
				front[i + 1] = tmp;
			}
			side[0] = front[0];
			side[2] = front[2];
		}
	}

	private static boolean notExceed(int nowX, int nowY, int dir) {
		return nowX + dx[dir] >= 0 && nowY + dy[dir] >= 0 && nowX + dx[dir] < n && nowY + dy[dir] < m;
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		List<int[]> list = new ArrayList<>();
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			list.add(poll);
			cnt++;
			for (int i = 0; i < 4; i++) {
				int newX = poll[0] + dx[i], newY = poll[1] + dy[i];
				if (newX >= 0 && newY >= 0 && newX < n && newY < m && !visited[newX][newY]
					&& map[newX][newY] == map[x][y]) {
					visited[newX][newY] = true;
					queue.offer(new int[] {newX, newY});
				}
			}
		}
		for (int[] ints : list) {
			stack[ints[0]][ints[1]] = cnt;
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
