package ps.programmers.level1;

// 연습문제 - 자연수 뒤집어 배열로 만들기
// 2022/03/14 00:48~00:50
public class MakeArrayReverseNumber {
	public int[] solution(long n) {
		return new StringBuilder(String.valueOf(n)).reverse().chars().map(c->c-=48).toArray();
	}
}
