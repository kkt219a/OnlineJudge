package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// 2022/06/13 11:05 ~ 11:25 = 20분
public class P14719 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int sum;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		String[] s = br.readLine().split(" ");
		int w = Integer.parseInt(s[1]);
		Stack<Integer> stack = new Stack<>();
		int start = -1;
		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int i=0;i<w;i++) {
			if(start <= arr[i]) {
				while(!stack.isEmpty()) {
					sum += (start - stack.pop());
				}
				start = arr[i];
			} else {
				stack.push(arr[i]);
			}
		}
		if(!stack.isEmpty()) {
			start = stack.pop();
			while(!stack.isEmpty()) {
				if(stack.peek() >= start) {
					start = stack.pop();
				} else {
					sum += (start - stack.pop());
				}
			}
		}
		System.out.println(sum);
	}
}
