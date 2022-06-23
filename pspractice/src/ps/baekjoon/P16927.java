package ps.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/06/23 17:27 ~ 16:15 = 48분
public class P16927 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m, r;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] rotate = rotate();
		for (int[] rot : rotate) {
			for (int i : rot) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[][] rotate() {
		int startX = 0, startY = 0, endX = n, endY = m;
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			System.arraycopy(arr[i], 0, copy[i], 0, m);
		}
		// 매 외곽을 순환
		for (; startX < endX && startY < endY; startX++, startY++, endX--, endY--) {
			int newR = r % ((endX - startX + endY - startY) * 2 - 4); // 회전 횟수
			int tempStartX = startX, tempStartY = startY;
			Point rotatePoint = getRotatePoint(tempStartX, tempStartY, endX, endY, newR);
			for (; tempStartX < endX - 1; tempStartX++) {
				copy[rotatePoint.x][rotatePoint.y] = arr[tempStartX][tempStartY];
				getNextPoint(rotatePoint, startX, startY, endX, endY);
			}
			for (; tempStartY < endY - 1; tempStartY++) {
				copy[rotatePoint.x][rotatePoint.y] = arr[tempStartX][tempStartY];
				getNextPoint(rotatePoint, startX, startY, endX, endY);
			}
			for (; tempStartX > startX; tempStartX--) {
				copy[rotatePoint.x][rotatePoint.y] = arr[tempStartX][tempStartY];
				getNextPoint(rotatePoint, startX, startY, endX, endY);
			}
			for (; tempStartY > startY; tempStartY--) {
				copy[rotatePoint.x][rotatePoint.y] = arr[tempStartX][tempStartY];
				getNextPoint(rotatePoint, startX, startY, endX, endY);
			}
		}
		return copy;
	}

	private static Point getRotatePoint(int startX, int startY, int endX, int endY, int newR) {
		int realX = startX, realY = startY;
		while (newR != 0) {
			int v;
			if (realX == startX && realY == startY) {
				v = Math.min(endX - startX - 1, newR);
				realX += v;
			} else if (realX == endX - 1 && realY == startY) {
				v = Math.min(endY - startY - 1, newR);
				realY += v;
			} else if (realX == endX - 1 && realY == endY - 1) {
				v = Math.min(endX - startX - 1, newR);
				realX -= v;
			} else {
				v = Math.min(endY - startY - 1, newR);
				realY -= v;
			}
			newR -= v;
		}
		return new Point(realX, realY);
	}

	private static void getNextPoint(Point current, int startX, int startY, int endX, int endY) {
		if (current.x < endX - 1 && current.y == startY) {
			current.translate(1, 0);
		} else if (current.x == endX - 1 && current.y < endY - 1) {
			current.translate(0, 1);
		} else if (current.x > startX && current.y == endY - 1) {
			current.translate(-1, 0);
		} else {
			current.translate(0, -1);
		}
	}

}
