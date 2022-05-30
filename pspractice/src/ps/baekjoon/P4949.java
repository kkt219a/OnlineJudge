package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 2022/05/30 17:33 ~ 17:47 = 14분
public class P4949 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		String tmp;
		while((tmp = br.readLine()) != null) {
			sb.append(tmp);
		}
		String[] sentences = sb.toString().split("\\.");
		for (String sentence : sentences) {
			char[] chars = sentence.toCharArray();
			Stack<Character> stack = new Stack<>();
			for (char aChar : chars) {
				if(aChar=='(' || aChar=='[') {
					stack.push(aChar);
				} else if(aChar == ')' || aChar == ']') {
					if(stack.isEmpty()) {
						stack.push('0');
						break;
					}
					Character peek = stack.peek();
					if((peek != '(' && aChar==')') || (peek != '[' && aChar==']')) {
						break;
					}
					stack.pop();
				}
			}
			System.out.println(stack.isEmpty() ? "yes" : "no");
		}
	}
}
