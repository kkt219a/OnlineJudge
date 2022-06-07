package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/07 10:41 ~ 11:48 = 67분
public class P16935 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,m;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<r;i++) {
			int r1 = Integer.parseInt(st.nextToken());
			if(r1<=2) {
				arr = reverse(arr, r1);
			} else if(r1<=4) {
				arr = rotate90(arr, r1);
			} else {
				arr = rotateMove(arr,r1);
			}
		}
		for (int[] arr2 : arr) {
			for (int i : arr2) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static int[][] reverse(int[][] origin, int num) {
		int[][] newArr = new int[n][m];
		for(int i=0;i< n;i++) {
			for(int j=0;j< m;j++) {
				if(num == 1) {
					newArr[i][j] = origin[n - i - 1][j];
				} else if(num==2) {
					newArr[i][j] = origin[i][m-j-1];
				}
			}
		}
		return newArr;
	}

	private static int[][] rotate90(int[][] origin, int num){
		int[][] newArr = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(num==3) {
					newArr[i][j] = origin[n-j-1][i];
				} else if(num==4) {
					newArr[i][j] = origin[j][m-i-1];
				}
			}
		}
		n = newArr.length;
		m = newArr[0].length;
		return newArr;
	}

	private static int[][] rotateMove(int[][] origin, int num) {
		int[][] newArr = new int[n][m];
		int[] dx = {n/2,0,-n/2,0};
		int[] dy = {0,-m/2,0,m/2};
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				int k = getK(i,j,num-5);
				newArr[i][j] = origin[i+dx[k]][j+dy[k]];
			}
		}
		return newArr;
	}

	private static int getK(int i, int j, int k) {
		if(i<n/2&&j<m/2) {
			return k==0 ? 0 : 3;
		} else if(i>=n/2&&j<m/2) {
			return k==0 ? 3 : 2;
		} else if(i>=n/2&&j>=m/2) {
			return k==0 ? 2 : 1;
		}
		return k==0 ? 1:0;
	}
}
