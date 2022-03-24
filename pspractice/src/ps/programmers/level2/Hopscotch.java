package ps.programmers.level2;

// 연습문제 - 땅따먹기
// 2022/03/24 20:20~20:45 = 25분
public class Hopscotch {
	int solution(int[][] land) {
		int answer = 0;
		int[][] dp = new int[land.length][4];
		dp[0] = land[0];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < 4; j++) {
				int max = -1;
				for (int k = 0; k < 4; k++) {
					if (j != k) {
						max = Math.max(max, dp[i - 1][k]);
					}
				}
				dp[i][j] = land[i][j] + max;
			}
		}
		for (int i = 0; i < 4; i++) {
			answer = Math.max(answer, dp[land.length - 1][i]);
		}
		return answer;
	}
}
