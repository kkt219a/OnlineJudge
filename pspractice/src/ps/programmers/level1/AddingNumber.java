package ps.programmers.level1;

// 월간 코드 챌린지 시즌3 - 없는 숫자 더하기
// 2022/03/02 19:17 ~ 19:19 = 2분
public class AddingNumber {
	public int solution(int[] numbers) {
		int answer = 45;
		for (int number : numbers) {
			answer -= number;
		}
		return answer;
	}
}
