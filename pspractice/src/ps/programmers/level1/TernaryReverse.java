package ps.programmers.level1;

// 월간 코드 챌린지 시즌1 - 3진법 뒤집기
// 2022/03/12 18:40~18:42 = 2분
public class TernaryReverse {
	public int solution(int n) {
		return Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(),3);
	}
}
