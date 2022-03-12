package ps.programmers.level1;

// 연습문제 - 약수의 합
// 2022/03/13 02:35~02:39 = 4분
public class DivisorSum {
	public int solution(int n) {
		int sum = 0;
		for(int i=1;i<=Math.sqrt(n);i++) {
			if(n%i==0) {
				sum += i;
				if(n/i != i) {
					sum += (n/i);
				}
			}
		}
		return sum;
	}
}
