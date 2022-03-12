package ps.programmers.level1;

// 연습문제 - 문자열 다루기 기본
// 2022/03/13 01:41~01:43 = 2분
public class StringDealDefault {
	public boolean solution(String s) {
		int length = s.length();
		try {
			Integer.parseInt(s);
			if((length == 4 || length == 6)) {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}
		return false;
	}
}
