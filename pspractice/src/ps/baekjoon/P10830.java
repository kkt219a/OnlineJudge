package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// 2022/06/23 12:17 ~ 01:00 : 53분
public class P10830 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[][] matrix;
	static int n;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		matrix = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] ints = multiplyMatrix(b);
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sb.append(ints[i][j]%1000).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[][] multiplyMatrix(long b) {
		if(b==1) {
			return matrix;
		} else {
			int[][] alpha = multiplyMatrix(b%2 == 0 ? b/2 : b-1);
			int[][] beta = b%2 == 0 ? alpha : matrix;
			int[][] newMatrix = new int[n][n];
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					for(int k=0;k<n;k++) {
						newMatrix[i][j] += alpha[i][k] * beta[k][j];
					}
					newMatrix[i][j] %= 1000;
				}
			}
			return newMatrix;
		}
	}
}
