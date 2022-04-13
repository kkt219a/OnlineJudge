package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 월간 코드 챌린지 시즌3 - n^2 배열 자르기
// 2022/04/13 21:45 ~ 22:35 = 50분, 다시
public class NSquareArraySplit {
	// 3, 2, 5
	public int[] solution(int n, long left, long right) {
		List<Long> ans = new ArrayList<>();
		long leftColumn = left/n +1; // 1
		long leftRow = left%n +1; // 3
		long rightColumn = right/n +1; // 2
		long rightRow = right%n +1; // 3
		System.out.println(leftColumn+" "+leftRow+" "+rightColumn+" "+rightRow);
		for(long tempLeftColumn = leftColumn; tempLeftColumn <= rightColumn; tempLeftColumn++) {
			long tempLeftRow = (leftColumn == tempLeftColumn) ? leftRow : 1; // 3
			long tempRightRow = (tempLeftColumn == rightColumn) ? rightRow : n; // 3
			System.out.println(tempLeftRow + " "+tempRightRow + " "+ tempLeftColumn);
			for(;tempLeftRow<=Math.min(tempRightRow, tempLeftColumn);ans.add(tempLeftColumn),tempLeftRow++);
			for(;tempLeftRow<=tempRightRow;ans.add(tempLeftRow), tempLeftRow++);
		}
		return ans.stream().mapToInt(Long::intValue).toArray();
	}

	public static void main(String[] args) {
		NSquareArraySplit nSquareArraySplit = new NSquareArraySplit();
		int[] solution = nSquareArraySplit.solution(4, 7, 14);
		System.out.println(Arrays.toString(solution));
	}
}
