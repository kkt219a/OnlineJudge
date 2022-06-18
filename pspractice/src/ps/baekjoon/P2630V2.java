package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/06/17 19:42 ~ 20:02 = 20분
public class P2630V2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] sum = new int[3];
	static int[][] map;
	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sum[divide(0,0,n)]++;
		System.out.println(sum[0]+" "+sum[1]);
	}

	// 흰:0, 파랑:1, 이미 처리:2
	private static int divide(int x, int y, int len) {
		if(len==1) {
			return map[x][y];
		} else {
			int nextLen = len/2;
			int a = divide(x,y,nextLen);
			int b = divide(x,y+nextLen,nextLen);
			int c = divide(x+nextLen,y,nextLen);
			int d = divide(x+nextLen,y+nextLen,nextLen);
			if(a==b&&b==c&&c==d&&a!=2) { // 처리한 게 아니고 색상이 다 같으면
				return a;
			} else {
				sum[a]++;
				sum[b]++;
				sum[c]++;
				sum[d]++;
				return 2;
			}
		}
	}
}
