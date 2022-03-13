package ps.programmers.level1;

// 연습문제 - 최대공약수와 최소공배수
// 2022/03/14 01:37~01:47
public class CollatzGuess {
	public int solution(int num) {
		long n = num;
		int i = 0;
		for(;i<500 && n!=1;i++) {
			n = (n%2==0) ? n/2 : n*3+1;
		}
		return n==1 ? i : -1;
	}
}
