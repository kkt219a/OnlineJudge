package ps.programmers.level3.stepping_stone;

import java.util.Arrays;

// 2019 카카오 개발자 겨울 인턴십 - 징검다리 건너기
// 2022/05/03 17:43 ~ 18:00, 솔루션 참고
public class SteppingStone {
	public int solution(int[] stones, int k) {
		int answer = Integer.MIN_VALUE;
		int[] stoneSort = new int[stones.length];
		int left = 0, right = stones.length-1;
		System.arraycopy(stones, 0, stoneSort, 0, stones.length);
		Arrays.sort(stoneSort);
		while(left<=right) {
			int mid = (left+right) /2;
			int value = stoneSort[mid];
			int skip = 0;
			for (int stone : stones) {
				if(skip == k) {
					break;
				}
				if(stone<value) {
					skip++;
				} else {
					skip = 0;
				}
			}
			if(skip==k) {
				right = mid-1;
			} else {
				answer = Math.max(answer, value);
				left = mid+1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		SteppingStone steppingStone = new SteppingStone();
		int solution = steppingStone.solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
		System.out.println(solution);
	}
}
