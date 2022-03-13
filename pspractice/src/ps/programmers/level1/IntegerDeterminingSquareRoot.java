package ps.programmers.level1;

// 연습문제 - 정수 제곱근 판별
// 2022/03/14 01:04~01:08
public class IntegerDeterminingSquareRoot {
	public long solution(long n) {
		double nn = Math.sqrt(n);
		return (nn==(long)nn)?(long)Math.pow(nn+1,2):-1;
	}
}
