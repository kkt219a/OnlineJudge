package ps.programmers.level2;

import java.util.Stack;

// 월간 코드 챌린지 시즌2 - 괄호 회전하기
// 2022/04/07 14:41~14:56 = 15분
public class RotateParentheses {
	public static void main(String[] args) {
		String a = "abcd";
	}

	public int solution(String s) {
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			char[] chars = (s.substring(i) + s.substring(0, i)).toCharArray();
			Stack<Character> st = new Stack<>();
			for (char aChar : chars) {
				if (st.isEmpty()) {
					st.push(aChar);
				} else if (
					(st.peek().equals('{') && aChar == '}')
					|| (st.peek().equals('[') && aChar == ']')
					|| (st.peek().equals('(') && aChar == ')')
				) {
					st.pop();
				} else {
					st.push(aChar);
				}
			}
			if (st.isEmpty()) {
				answer++;
			}
		}
		return answer;
	}
}
