package ps.programmers.level2;

import java.util.Stack;

// 2017 팁스타운 - 짝지어 제거하기
// 2022/03/15 15:15 - 못품 - 이걸 왜 틀리냐 하
public class PairRemove {
	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		for (char aChar : chars) {
			if(!stack.isEmpty() && stack.peek().equals(aChar)) {
				stack.pop();
			} else {
				stack.push(aChar);
			}
		}
		return stack.size() == 0 ? 1:0;
	}
}
