package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/05/31 15:31 ~ 15:51 = 20분
public class P22858 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int k;
	static int[] s;
	static int[] d;
	static int[] tempP;

	public static void main(String[] args) throws IOException {
		String[] infos = br.readLine().split(" ");
		n = Integer.parseInt(infos[0]);
		k = Integer.parseInt(infos[1]);
		s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		d = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i=0;i<k;i++) {
			tempP = new int[n];
			for(int j=0;j<n;j++) {
				tempP[d[j]-1] = s[j];
			}
			s = tempP;
		}
		for (int i : s) {
			System.out.print(i+" ");
		}
	}
}
