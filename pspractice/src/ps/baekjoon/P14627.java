package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/08 10:10 ~ 11:10x = 60분
public class P14627 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[s+1];
		arr[0] = 0;
		long sum = 0;
		for(int i=1;i<=s;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		int binarySearch = binarySearch(arr, m)-1;
		System.out.println(sum- (long)m *binarySearch);
	}

	private static int binarySearch(int[] arr, int m) {
		int left = 1, right = arr[arr.length-1]+1;
		while(left < right) {
			int mid = (left+right) / 2, tempSum = 0;
			for(int i=1;i<arr.length;i++) {
				tempSum += arr[i] / mid;
			}
			if(tempSum >= m) {
				left = mid+1;
			} else {
				right = mid;
			}
		}
		return left;
	}
}
