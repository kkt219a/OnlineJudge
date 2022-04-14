package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 2022 KAKAO BLIND RECRUITMENT - 양궁대회
// 2022/04/14 16:00~18:22 = 142분 ,.,.,.., 답도보고 .... 다시......
public class ArcheryCompetition {
	int[] apeachInfo;
	int[] rianInfo = {-1};
	int rianMaxScore = Integer.MIN_VALUE;
	int nn;

	public int[] solution(int n, int[] info) {
		nn = n;
		apeachInfo = info;
		dfs(0,"", n);
		return rianInfo;
	}

	public void dfs(int idx, String rianScore, int remainArrow) {
		if(idx == 11) {
			calculate(rianScore);
		} else if(idx < 11){
			int nowArrowNum = apeachInfo[idx]+1;
			dfs(idx+1, rianScore+"0"+" ", remainArrow);// 안쏘기
			if(remainArrow >= nowArrowNum) {
				dfs(idx+1, rianScore+nowArrowNum+" ", remainArrow-nowArrowNum); // 어피치보다 한 발 더쏘기
			} if(remainArrow > 0){
				dfs(idx+1, rianScore+remainArrow+" ", 0); // 남은 화살 다 쏘기
			}
		}
	}

	private void calculate(String rianScore) {
		int[] rianScoreArray = Arrays.stream(rianScore.split(" ")).mapToInt(Integer::parseInt).toArray();
		if(Arrays.stream(rianScoreArray).sum() == nn) {
			int tempRianScore = 0;
			int tempApeachScore = 0;
			for (int i = 0; i < 11; i++) {
				if (rianScoreArray[i] > apeachInfo[i]) {
					tempRianScore += (10 - i);
				} else if (rianScoreArray[i] != 0 || apeachInfo[i] != 0) {
					tempApeachScore += (10 - i);
				}
			}
			if (tempRianScore > tempApeachScore) {
				if (tempRianScore-tempApeachScore > rianMaxScore) {
					rianInfo = rianScoreArray.clone();
					rianMaxScore = tempRianScore-tempApeachScore;
				} else if (tempRianScore-tempApeachScore == rianMaxScore) {
					boolean pass = true;
					for (int i = 10; i >= 0; i--) {
						if (rianScoreArray[i] < rianInfo[i]) {
							pass = false;
							break;
						} else if(rianScoreArray[i] > rianInfo[i]) {
							break;
						}
					}
					if (pass) {
						rianInfo = rianScoreArray.clone();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ArcheryCompetition archeryCompetition = new ArcheryCompetition();
		int[] solution = archeryCompetition.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3});
		System.out.println(Arrays.toString(solution));
	}
}
