package ps.programmers.level1;

import java.util.Arrays;

//찾아라 프로그래밍 마에스터 - 폰켓몬
// 2022/03/02 23:06~23:14 = 8분
public class Phonecketmon {
	public int solution(int[] nums) {
		int[] dis = Arrays.stream(nums)
			.distinct().toArray();
		return Math.max(dis.length, nums.length/2);
	}
}
