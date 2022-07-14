package ps.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2022/07/13 15:57 ~ 17:41 = 104분
public class P15644 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m, min = Integer.MAX_VALUE;
	static char[][] map;
	static Point red, blue;
	static char[] dir = {'U','D','L','R'};
	static String paths = "";

	public static void main(String[] args) throws IOException {
		newToken();
		n = parseIntSt();
		m = parseIntSt();
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < chars.length; j++) {
				map[i][j] = chars[j];
				if (map[i][j] == 'R') {
					map[i][j] = '.';
					red = new Point(i, j);
				} else if (map[i][j] == 'B') {
					map[i][j] = '.';
					blue = new Point(i, j);
				}
			}
		}
		dfs(red, blue, 1,"");
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		if(min != Integer.MAX_VALUE) {
			System.out.println(paths);
		}
	}

	static void dfs(Point red, Point blue, int depth, String path) {
		if (depth <= 10 && depth<=min) {
			for (int v = 0; v < 4; v++) {
				Point moveRed, moveBlue;
				if(v==0) {
					if(blue.x < red.x) {
						moveBlue = move(v, blue, red);
						moveRed = move(v, red, moveBlue);
					} else {
						moveRed = move(v, red, blue);
						moveBlue = move(v, blue, moveRed);
					}
				} else if(v==1) {
					if(blue.x < red.x) {
						moveRed = move(v, red, blue);
						moveBlue = move(v, blue, moveRed);
					} else {
						moveBlue = move(v, blue, red);
						moveRed = move(v, red, moveBlue);
					}
				} else if(v==2) {
					if(blue.y < red.y) {
						moveBlue = move(v, blue, red);
						moveRed = move(v, red, moveBlue);
					} else {
						moveRed = move(v, red, blue);
						moveBlue = move(v, blue, moveRed);
					}
				} else {
					if(blue.y < red.y) {
						moveRed = move(v, red, blue);
						moveBlue = move(v, blue, moveRed);
					} else {
						moveBlue = move(v, blue, red);
						moveRed = move(v, red, moveBlue);
					}
				}
				if (map[moveRed.x][moveRed.y] == 'O') {
					if(map[moveBlue.x][moveBlue.y] != 'O') {
						min = Math.min(min, depth);
						paths = path+dir[v];
					}
				} else if (map[moveBlue.x][moveBlue.y] != 'O' && ((red.x != moveRed.x || red.y != moveRed.y)||(blue.x != moveBlue.x || blue.y != moveBlue.y))) {
					dfs(moveRed, moveBlue, depth + 1, path+dir[v]);
				}
			}
		}
	}

	// 어떠한 장애물을 만나면 일단 그 이전 위치를 반환한다.
	private static Point move(int val, Point move, Point dontMove) {
		if (val == 0) { // 상
			for (int i = move.x; i > 0; i--) {
				// 구멍이거나, 다음이 벽이거나, 다음이 구멍이 아닌데 구슬이 존재하는 경우 중단.
				if (map[i][move.y] == 'O'
					|| map[i - 1][move.y] == '#'
					|| (map[i - 1][move.y] != 'O' && i - 1 == dontMove.x && move.y == dontMove.y)
				) {
					return new Point(i, move.y);
				}
			}
		} else if (val == 1) { //하
			for (int i = move.x; i < n - 1; i++) {
				if (map[i][move.y] == 'O'
					|| map[i + 1][move.y] == '#'
					|| (map[i + 1][move.y] != 'O' && i + 1 == dontMove.x && move.y == dontMove.y)
				) {
					return new Point(i, move.y);
				}
			}
		} else if (val == 2) { //좌
			for (int i = move.y; i > 0; i--) {
				if (map[move.x][i] == 'O'
					|| map[move.x][i - 1] == '#'
					|| (map[move.x][i - 1] != 'O' && move.x == dontMove.x && i - 1 == dontMove.y)
				) {
					return new Point(move.x, i);
				}
			}
		} else if (val == 3) { //우
			for (int i = move.y; i < m - 1; i++) {
				if (map[move.x][i] == 'O'
					|| map[move.x][i + 1] == '#'
					|| (map[move.x][i + 1] != 'O' && move.x == dontMove.x && i + 1 == dontMove.y)
				) {
					return new Point(move.x, i);
				}
			}
		}
		return new Point();
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
