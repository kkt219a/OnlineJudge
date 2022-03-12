package ps.programmers.level1;

// 월간 코드 챌린지 시즌3 - 나머지가 1이 되는 수 찾기
// 2022/03/12 19:36~19:37 = 1분
public class BecomeRemainderOne {
	public int solution(int n) {
		for(int i=1;i<n;i++) {
			if(n%i==1) {
				return i;
			}
		}
		return 0;
	}
}
