package ps.programmers.level1;

import java.util.Arrays;

// Summer/Winter Coding(~2018) - 예산
// 2022/03/12 18:44~18:46 = 2분
public class Budget {
	public int solution(int[] d, int budget) {
		Arrays.sort(d);
		int answer = 0;
		for (int i : d) {
			budget-=i;
			if(budget<0) {
				break;
			}
			answer++;
		}
		return answer;
	}
}
