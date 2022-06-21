package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/06/21 01:58 ~ 02:20 = 22분
public class P16926 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n,m,r;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		arr = new int[n+1][m+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		arr = rotate();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int[][] rotate() {
		int[][] temp = new int[n+1][m+1];
		for(int i=1,j=1,k=n,l=m;i<=k&&j<=l;i++,j++,k--,l--) {
			for(int rrr=0, rr = r % (2*(k+l)-4);rrr<=rr;rrr++) {
				System.out.println(k+" "+l+rr);
				int a = i, b = j;
				for (; a < k; a++) {
					temp[a + 1][b] = arr[a][b];
				}
				for (; b < l; b++) {
					temp[a][b + 1] = arr[a][b];
				}
				for (; a > i; a--) {
					temp[a - 1][b] = arr[a][b];
				}
				for (; b > j; b--) {
					temp[a][b - 1] = arr[a][b];
				}
			}
		}
		return temp;
	}
}
