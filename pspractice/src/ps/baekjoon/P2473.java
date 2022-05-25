package ps.baekjoon;

import java.io.*;
import java.util.*;

// 2022/05/25 22:40 ~ 23:36 , 해설
public class P2473 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Long> ret;
	static long minSum = Long.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		br.readLine();
		long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		Arrays.sort(arr);
		for(int i=0;i< arr.length;i++) {
			int left = i+1, right = arr.length-1;
			while(left<right) {
				long sum = arr[left] + arr[right] + arr[i];
				if(Math.abs(sum) < Math.abs(minSum)) {
					minSum = sum;
					ret = new ArrayList<>(List.of(arr[left],arr[right],arr[i]));
				}
				if(sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		Collections.sort(ret);
		for (Long v : ret) {
			System.out.print(v+" ");
		}
	}
}
