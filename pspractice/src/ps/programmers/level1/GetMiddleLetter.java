package ps.programmers.level1;

// 연습문제 - 가운데 글자 가져오기
// 2022/03/12 19:31~19:35 = 4분
public class GetMiddleLetter {
	public String solution(String s) {
		return (s.length()%2 == 1) ? s.substring(s.length()/2,s.length()/2+1) : s.substring(s.length()/2-1,s.length()/2+1);
	}
}
