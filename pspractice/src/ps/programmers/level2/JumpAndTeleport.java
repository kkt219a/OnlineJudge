package ps.programmers.level2;

// Summer/Winter Coding(~2018) - 점프와 순간 이동
// 2022/03/27 15:25~15:38
public class JumpAndTeleport {
	public int solution(int n) {
		int answer = 0;
		for(;n!=1;) {
			boolean even = n % 2 == 0;
			if(n % 2 == 0) {
				n /= 2;
			} else {
				n-=1;
				answer++;
			}
		}
		return answer;
	}
}
