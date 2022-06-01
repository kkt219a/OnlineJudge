package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 2022/06/01 10:42 ~ 10:56 = 14분
public class P2467 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int sum = Integer.MAX_VALUE;
	static int a, b;

	public static void main(String[] args) throws IOException {
		br.readLine();
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(arr);
		for(int left=0, right= arr.length-1;left < right;) {
			int tempSum = arr[left] + arr[right];
			if(Math.abs(tempSum)<Math.abs(sum)) {
				a=arr[left];
				b=arr[right];
				sum = a+b;
			}
			if(tempSum<=0) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(a+" "+b);
	}
}
