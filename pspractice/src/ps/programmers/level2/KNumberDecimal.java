package ps.programmers.level2;

// 2022 KAKAO BLIND RECRUITMENT - k진수에서 소수 개수 구하기
// 2022/03/02 18:12~ 18:32 --> 다시
public class KNumberDecimal {
	public int solution(int n, int k) {
		int answer = 0;
		String[] decimals = Integer.toString(n, k).split("0");
		for (String decimal : decimals) {
			if(decimal.isBlank()) {
				continue;
			}
			long number = Long.parseLong(decimal);
			if(isPrimer(number)) {
				answer++;
			}
		}
		return answer;
	}

	public boolean isPrimer(long number) {
		if (number < 2) {
			return false;
		}
		for(int i=2;i<=Math.sqrt(number);i++) {
			if(number%i==0) {
				return false;
			}
		}
		return true;
	}
}
