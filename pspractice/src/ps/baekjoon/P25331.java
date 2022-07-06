package ps.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 2022/07/02 9시간
public class P25331 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int min = Integer.MAX_VALUE, total, ballNum;
	static int[][] map = new int[7][7];
	static int[] startZero = new int[7];

	public static void main(String[] args) throws IOException {
		Arrays.fill(startZero, -1);
		for (int i = 0; i < 7; i++) {
			newToken();
			for (int j = 0; j < 7; j++) {
				map[i][j] = parseIntSt();
				if (map[i][j] != 0) {
					total++;
				} else {
					startZero[j]++;
				}
			}
		}
		ballNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < 7; i++) {
			int[][] newArr = new int[7][7];
			for (int j = 0; j < 7; j++) {
				System.arraycopy(map[j], 0, newArr[j], 0, 7);
			}
			min = Math.min(min, func(total, newArr, i));
		}
		System.out.println(min);
	}

	private static int func(int total, int[][] arr, int column) {
		arr[startZero[column]][column] = ballNum;
		total++;
		List<Point> removePoints;
		while (true) {
			removePoints = new ArrayList<>();
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if (arr[i][j] != 0) {
						int columnCnt = 1;
						int rowCnt = 1;
						for (int k = j - 1; k >= 0 && arr[i][k] != 0; k--) {
							columnCnt++;
						}
						for (int k = j + 1; k < 7 && arr[i][k] != 0; k++) {
							columnCnt++;
						}
						for (int k = i - 1; k >= 0 && arr[k][j] != 0; k--) {
							rowCnt++;
						}
						for (int k = i + 1; k < 7 && arr[k][j] != 0; k++) {
							rowCnt++;
						}
						if (columnCnt == arr[i][j] || rowCnt == arr[i][j]) {
							removePoints.add(new Point(i, j));
						}
					}
				}
			}
			for (Point removePoint : removePoints) {
				int x = removePoint.x, y = removePoint.y;
				arr[x][y] = 0;
				for (int k = x - 1; k >= 0; k--) {
					if (arr[k][y] > 0) {
						int tmp = arr[k][y];
						arr[k][y] = arr[k + 1][y];
						arr[k + 1][y] = tmp;
					}
				}
				total--;
			}
			if (removePoints.isEmpty()) {
				break;
			}
		}
		return total;
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
