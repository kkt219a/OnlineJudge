package ps.programmers.level2;

// 연습문제 - JadenCase 문자열 만들기
// 15:33~15:47 = 14분
public class JadenCaseMakeString {
	public String solution(String s) {
		String[] jadens = s.split("");
		boolean prevEmpty = true;
		StringBuilder sb = new StringBuilder();
		for (String jaden : jadens) {
			if (prevEmpty && !jaden.isBlank()) {
				sb.append(jaden.toUpperCase());
				prevEmpty = false;
			} else if (!prevEmpty && !jaden.isBlank()) {
				sb.append(jaden.toLowerCase());
			} else {
				prevEmpty = true;
				sb.append(jaden);
			}
		}
		return sb.toString();
	}
}

