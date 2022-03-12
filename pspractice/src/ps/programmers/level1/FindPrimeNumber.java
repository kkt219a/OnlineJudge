package ps.programmers.level1;

// 연습문제 - 소수 찾기
// 2022/03/13 01:54~02:09 = 15분
public class FindPrimeNumber {
	int nn = 1000000;
	boolean[] prime = new boolean[nn+1];
	private void checkPrime() {
		prime[1] = true;
		for(int i=2;i*i<=nn;i++) {
			if(!prime[i]) {
				for (int j = i*i; j<=nn ; j += i) {
					prime[j] = true;
				}
			}
		}
	}
	public int solution(int n) {
		checkPrime();
		int ans = 0;
		for(int i=1;i<=n;i++) {
			if(!prime[i]) {
				ans++;
			}
		}
		return ans;
	}
}
