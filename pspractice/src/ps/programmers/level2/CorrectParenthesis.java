package ps.programmers.level2;

import java.util.Stack;

// 연습문제 - 올바른 괄호
// 15:48~16:04 = 16분
public class CorrectParenthesis {
	boolean solution(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if(aChar==')') {
				if(stack.empty()) {
					return false;
				} else if(stack.peek().equals('(')) {
					stack.pop();
				}
			} else {
				stack.push(aChar);
			}
		}
		return stack.empty();
	}
}
