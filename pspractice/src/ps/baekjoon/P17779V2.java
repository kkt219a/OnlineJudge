package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 해설참조
public class P17779V2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] persons;
	static boolean[][] map;
	static int[] maxi;
	static int min = Integer.MAX_VALUE;
	static int total;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		persons = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				persons[i][j] = Integer.parseInt(st.nextToken());
				total += persons[i][j];
			}
		}
		for(int x = 1; x <= n; x++) {
			for(int y = 1; y <= n; y++) {
				for(int d1 = 1;1 <= y-d1 && y-d1 < y;d1++) {
					for(int d2 = 1;y<y+d2 && y+d2<=n && x<x+d1+d2 && x+d1+d2<=n;d2++) {
						map = new boolean[n+1][n+1];
						maxi = new int[5];
						five(x,y,d1,d2);
					}
				}
			}
		}
		System.out.println(min);
	}

	private static void five(int x, int y, int d1, int d2) {
		for(int i=x, j=y;i<=x+d1&&j>=y-d1;i++,j--) {
			map[i][j] = true;
		}
		for(int i=x, j=y;i<=x+d2 && j<=y+d2;i++,j++) {
			map[i][j] = true;
		}
		for(int i=x+d1, j=y-d1;i<=x+d1+d2&&j<=y-d1+d2;i++, j++) {
			map[i][j] = true;
		}
		for(int i=x+d2, j=y+d2;i<=x+d1+d2&&j>=y+d2-d1;i++, j--) {
			map[i][j] = true;
		}
		for(int i=1;i<x+d1;i++) {
			for(int j=1;j<=y;j++) {
				if(map[i][j]) {
					break;
				}
				maxi[0] += persons[i][j];
			}
		}
		for(int i=1;i<=x+d2;i++) {
			for(int j=n;j>=y+1;j--) {
				if(map[i][j]) {
					break;
				}
				maxi[1] += persons[i][j];
			}
		}
		for(int i=x+d1;i<=n;i++) {
			for(int j=1;j<y-d1+d2;j++) {
				if(map[i][j]) {
					break;
				}
				maxi[2] += persons[i][j];
			}
		}
		for(int i=x+d2+1;i<=n;i++) {
			for(int j=n;j>=y-d1+d2;j--) {
				if(map[i][j]) {
					break;
				}
				maxi[3] += persons[i][j];
			}
		}
		maxi[4] = total - maxi[0] - maxi[1] - maxi[2] - maxi[3];
		Arrays.sort(maxi);
		min = Math.min(min, maxi[4]-maxi[0]);
	}
}
