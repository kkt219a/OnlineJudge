package ps.programmers.level1;

// 월간 코드 챌린지 시즌2 - 약수의 개수와 덧셈
// 2022/03/03 00:07~00:13 = 6분
public class DivisorNumberAdd {
	int[] prime = new int[1001];
	public int solution(int left, int right) {
		int answer = 0;
		ela();
		for(int i=left;i<right;i++) {
			answer += (i*(prime[i]%2==0 ? 1:-1));
		}
		return answer;
	}
	private void ela() {
		for(int i=1;i<1001;i++) {
			for(int j=1;i*j<1001;j++) {
				prime[i*j]++;
			}
		}
	}
}
