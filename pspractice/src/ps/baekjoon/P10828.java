package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 2022/06/06 10:14 ~ 10:22 = 8분
public class P10828 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Stack<Integer> s = new Stack<>();

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String bash = st.nextToken();
			if (bash.equals("push")) {
				s.push(Integer.parseInt(st.nextToken()));
				continue;
			} else if (bash.equals("pop")) {
				sb.append(s.isEmpty() ? -1 : s.pop());
			} else if (bash.equals("size")) {
				sb.append(s.size());
			} else if (bash.equals("empty")) {
				sb.append(s.isEmpty() ? 1 : 0);
			} else if (bash.equals("top")) {
				sb.append(s.isEmpty() ? -1 : s.peek());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
