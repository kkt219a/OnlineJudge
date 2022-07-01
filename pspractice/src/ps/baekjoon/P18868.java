package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/07/01
public class P18868 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] arr;
	static int n, m;

	public static void main(String[] args) throws IOException {
		newToken();
		m = parseIntSt();
		n = parseIntSt();
		int total = 0;
		arr = new int[m][n];
		for(int i=0;i<m;i++) {
			newToken();
			for(int j=0;j<n;j++) {
				arr[i][j] = parseIntSt();
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=i+1;j<m;j++) {
				if(compare(arr[i],arr[j])) {
					total++;
				}
			}
		}
		System.out.println(total);
	}

	private static boolean compare(int[] a, int[] b) {
		for(int j=0;j<n;j++) {
			for (int k = j+1; k < n; k++) {
				int v1 = a[j], v2 = a[k];
				int vv1 = b[j], vv2 = b[k];
				if(Integer.compare(v1,v2) != Integer.compare(vv1,vv2)) {
					return false;
				}
			}
		}
		return true;
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}
}
