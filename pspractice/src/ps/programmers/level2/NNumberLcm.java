package ps.programmers.level2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 연습문제 - N개의 최소공배수
// 15:20~15:31 = 11분
public class NNumberLcm {
	public int solution(int[] arr) {
		List<BigInteger> collect = Arrays.stream(arr)
			.mapToObj(BigInteger::valueOf)
			.collect(Collectors.toList());
		BigInteger prev = null;
		for (BigInteger bigInteger : collect) {
			if(prev==null) {
				prev = bigInteger;
				continue;
			}
			prev = (prev.multiply(bigInteger)).divide(prev.gcd(bigInteger));
		}
		return prev.intValue();
	}
}
