package ps.programmers.level1;

// 연습문제 - 자릿수 더하기
// 2022/03/14 00:45~00:46
public class DigitAdd {
	public int solution(int n) {
		String[] split = String.valueOf(n).split("");
		int sum = 0;
		for (String s : split) {
			sum += Integer.parseInt(s);
		}
		return sum;
	}
}
