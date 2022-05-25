package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2022/05/25 16:34 ~ 17:04 = 30분, 더 쉽게 풀기
public class P2847 {
	static int[] arr = new int[100];
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0;i<t;i++) {
			int minV = arr[i];
			int minVIdx = i;
			int minCnt = 0;
			for(int j=i+1;j<t;j++) {
				if(minV>=arr[j]) {
					minV = arr[j];
					minVIdx = j;
				}
			}
			for(int j=i;j<minVIdx;j++) {
				if(arr[j]>=minV) {
					minCnt++;
				}
			}
			if(minCnt != 0) {
				ans += (arr[i] - minV + minCnt);
			}
		}
		System.out.println(ans);
	}
}
