package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/15 18:06 ~ 19:54 = 108분
public class P17779 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] persons;
	static int[][] map;
	static int[] maxi;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		persons = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=n;j++) {
				persons[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int x = 1; x <= n; x++) {
			for(int y = 1; y <= n; y++) {
				for(int d1 = 1;1 <= y-d1 && y-d1 < y;d1++) {
					for(int d2 = 1;y<y+d2 && y+d2<=n && x<x+d1+d2 && x+d1+d2<=n;d2++) {
						map = new int[n+1][n+1];
						maxi = new int[5];
						five(x,y,d1,d2);
						min = Math.min(min, Arrays.stream(maxi).max().orElse(0) - Arrays.stream(maxi).min().orElse(0));
					}
				}
			}
		}
		System.out.println(min);
	}

	private static void five(int x, int y, int d1, int d2) {
		for(int i=1;i<x+d1;i++) {
			for(int j=1;j<=y;j++) {
				map[i][j] = 0;
			}
		}
		for(int i=1;i<=x+d2;i++) {
			for(int j=y+1;j<=n;j++) {
				map[i][j] = 1;
			}
		}
		for(int i=x+d1;i<=n;i++) {
			for(int j=1;j<y-d1+d2;j++) {
				map[i][j] = 2;
			}
		}
		for(int i=x+d2+1;i<=n;i++) {
			for(int j=y-d1+d2;j<=n;j++) {
				map[i][j] = 3;
			}
		}
		for(int i=x, j=y;i<=x+d1&&j>=y-d1;i++,j--) {
			map[i][j] = 4;
		}
		for(int i=x, j=y;i<=x+d2 && j<=y+d2;i++,j++) {
			map[i][j] = 4;
		}
		for(int i=x+d1, j=y-d1;i<=x+d1+d2&&j<=y-d1+d2;i++, j++) {
			map[i][j] = 4;
		}
		for(int i=x+d2, j=y+d2;i<=x+d1+d2&&j>=y+d2-d1;i++, j--) {
			map[i][j] = 4;
		}
		for(int i=1;i<=n;i++) {
			long cnt = Arrays.stream(map[i]).filter(v -> v == 4).count();
			if(cnt>1) {
				for(int j=1;j<=n;j++) {
					if(map[i][j]==4) {
						for(int k=j+1;k<=n && map[i][k] != 4;map[i][k]=4,k++);
						break;
					}
				}
			}
			for(int j=1;j<=n;j++) {
				maxi[map[i][j]] += persons[i][j];
			}
		}
	}
}
