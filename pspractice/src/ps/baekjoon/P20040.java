package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/06/14 13:54 ~ xx:xx = xx분
public class P20040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int[n+1];
		int i = 1;
		for(;i<=n;parents[i]=i,i++);
		for(i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(union(a,b)) {
				break;
			}
		}
		System.out.println(i==m+1 ? 0 : i);
	}

	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a<b) {
			parents[b] = a;
		} else if(a>b) {
			parents[a] = b;
		}
		return a==b;
	}

	private static int find(int a) {
		if(parents[a]==a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
}
