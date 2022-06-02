package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/02 17:28 ~ 17:41 = 13분
public class P21921 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, x;
	static int maxPeriod;
	static int maxVisited;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		int[] visitMembers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int sum = 0, j=0;
		for(;j<x;j++) {
			sum+= visitMembers[j];
		}
		for(int i=0;j<=n;i++,j++) {
			if(sum>maxVisited) {
				maxVisited = sum;
				maxPeriod = 1;
			} else if(sum==maxVisited) {
				maxPeriod++;
			}
			if(j!=n) {
				sum += (visitMembers[j] - visitMembers[i]);
			}
		}
		if(maxVisited==0) {
			System.out.println("SAD");
		} else {
			System.out.println(maxVisited);
			System.out.println(maxPeriod);
		}

	}
}
