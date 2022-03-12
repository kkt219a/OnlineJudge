package ps.programmers.level1;

// 연습문제 - 수박수박수박수박수박수?
// 2022/03/13 02:12~02:14 = 2분
public class WaterMelon {
	public String solution(int n) {
		return "수박".repeat(n/2) + ((n%2==0) ? "" : "수");
	}
}
