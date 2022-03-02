package ps.programmers.level1;

// 월간 코드 챌린지 시즌2 - 음양 더하기
// 2022/03/02 19:22 ~ 19:24 = 2분
public class MinusPlusAdd {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		for(int i=0;i< signs.length;i++) {
			answer += signs[i] ? absolutes[i] : -1*absolutes[i];
		}
		return answer;
	}
}
