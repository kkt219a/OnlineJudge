package ps.programmers.level1;

// 월간 코드 챌린지 시즌1 - 내적
// 2022/03/02 19:25 ~ 19:26 = 1분
public class Inner {
	public int solution(int[] a, int[] b) {
		int answer = 0;
		for(int i=0;i< a.length;i++) {
			answer += (a[i]*b[i]);
		}
		return answer;
	}
}
