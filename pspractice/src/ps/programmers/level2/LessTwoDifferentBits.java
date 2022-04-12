package ps.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// 월간 코드 챌린지 시즌2 - 2개 이하로 다른 비트
// 2022/04/13 02:03~02:25 = 22분
public class LessTwoDifferentBits {
	public long[] solution(long[] numbers) {
		List<Long> answers = new ArrayList<>();
		for (long number : numbers) {
			int cnt=0;
			String nextNum = Long.toBinaryString(number+1);
			String binary = Long.toBinaryString(number);
			binary = nextNum.length() != binary.length() ? "0"+binary : binary;
			for(int i=0;i<nextNum.length();i++) {
				cnt += nextNum.charAt(i) != binary.charAt(i) ? 1 : 0;
			}
			long ans = cnt<=2 ? number+1 : number+(long)Math.pow(2,cnt-2);
			answers.add(ans);
		}
		return answers.stream()
			.mapToLong(Long::longValue)
			.toArray();
	}
}
