package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// 2022/05/31 16:51 ~ 17:04 = 13분
public class P2812 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int k;
	static Stack<Character> s = new Stack<>();

	public static void main(String[] args) throws IOException {
		String[] infos = br.readLine().split(" ");
		n = Integer.parseInt(infos[0]);
		k = Integer.parseInt(infos[1]);
		char[] sentences = br.readLine().toCharArray();
		for (char sentence : sentences) {
			while (!s.isEmpty() && s.peek() < sentence && k > 0) {
				k--;
				s.pop();
			}
			s.push(sentence);
		}
		while(k > 0 && !s.isEmpty()) {
			k--;
			s.pop();
		}
		for (Character c : s) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
