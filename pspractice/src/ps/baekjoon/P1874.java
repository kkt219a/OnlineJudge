package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 2022/06/26 02:27 ~ 02:37 = 10분
public class P1874 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws Exception {
		int n = read();
		int start = 1;
		for (int i = 0; i < n; i++) {
			int k = read();
			for (; start <= k; start++) {
				stack.push(start);
				sb.append("+\n");
			}
			Integer pop = stack.pop();
			if(pop!=k) {
				sb = new StringBuilder("NO");
				break;
			}
			sb.append("-\n");
		}
		System.out.println(sb);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

}
