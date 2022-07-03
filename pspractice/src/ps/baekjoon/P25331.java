package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/07/02 16:19 ~ xx:xx = xx분
public class P25331 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int tot, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		int[][] width = new int[7][7];
		int[][] height = new int[7][7];
		int[] start0 = new int[7];
		for(int i=0;i<7;i++) {
			newToken();
			for(int j=0;j<7;j++) {
				width[i][j] = parseIntSt();
				height[j][i] = width[i][j];
				if(height[j][i] == 0) {
					start0[j] = i;
				} else {
					tot++;
				}
			}
		}
		for(int j=1;j<=7;j++){
			for (int i = 0; i < 7; i++) {
				int[][] copyWidth = copy(width);
				int[][] copyHeight = copy(height);
				min = Math.min(min, poping(tot, j, i, start0[i], copyWidth, copyHeight));
			}
		}
		System.out.println(min);
	}

	private static int[][] copy(int[][] copy) {
		int[][] temp = new int[7][7];
		for(int i=0;i<7;i++) {
			System.arraycopy(copy[i], 0, temp[i], 0, 7);
		}
		return temp;
	}

	private static int poping(int tot, int ball, int idx, int start0Idx, int[][] width, int[][] height) {
		height[idx][start0Idx] = ball;
		width[start0Idx][idx] = ball;
		boolean change = true;
		while(change) {
			change = false; // 변화가 종료된다고 가정
			for(int i=0;i<7;i++) {
				int total = 0; // 0이 아닌 갯수 세기, 사이즈
				for(int j=0;j<7;j++) {
					if(height[i][j] != 0) {
						total++;
					}
				}
				// 사이즈와 같으면 제거 후 위에 있는게 밑으로
				for(int j=0;j<7;j++) {
					if(height[i][j] == total && total !=0) {
						for(int k=0;k<j;k++) {
							height[i][k+1] = height[i][k];
							width[k+1][i] = width[k][i];
						}
						height[i][0] = 0;
						width[0][i] = 0;
						tot--;
						change = true;
					}
				}
			}
			for(int i=0;i<7;i++) {
				int total = 0;
				for(int j=0;j<7;j++) {
					if(width[i][j] != 0) {
						total++;
					}
				}
				for(int j=0;j<7;j++) {
					if(width[i][j] == total && total != 0) {
						for(int k=0;k<i;k++) {
							width[k+1][j] = width[k][j];
							height[j][k+1] = height[j][k];
						}
						width[0][j] = 0;
						height[j][0] = 0;
						tot--;
						change = true;
					}
				}
			}
		}
		return tot;
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
