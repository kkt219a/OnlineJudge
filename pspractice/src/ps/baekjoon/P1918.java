package ps.baekjoon;

import java.io.*;
import java.util.Stack;

// 2022/05/31 12:48 ~ X 해설 참조
public class P1918 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Stack<Character> s = new Stack<>();

	public static void main(String[] args) throws IOException {
		char[] formula = br.readLine().toCharArray();
		for (char c : formula) {
			if (c > 64 && c < 91) {
				System.out.print(c);
			} else {
				if (c == ')') {
					while (!s.isEmpty() && s.peek() != '(') {
						System.out.print(s.pop());
					}
					s.pop();
					continue;
				} else if (c == '+' || c == '-') {
					while (!s.isEmpty() && s.peek() != '(') {
						System.out.print(s.pop());
					}
				} else if (c == '*' || c == '/') {
					while (!s.isEmpty() && (s.peek() == '*' || s.peek() == '/')) {
						System.out.print(s.pop());
					}
				}
				s.push(c);
			}
		}
		while (!s.isEmpty()) {
			System.out.print(s.pop());
		}
	}
}
