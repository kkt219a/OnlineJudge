package ps.programmers.level3.not_destroy_construct;

// 2022 KAKAO BLIND RECRUITMENT - 파괴되지 않은 건물(정확성)
// 2022/04/22 01:45~01:51
public class NotDestroyConstructV1 {
	public int solution(int[][] board, int[][] skill) {
		for (int[] s : skill) {
			if(s[0]==1) {
				for(int i=s[1];i<=s[3];i++) {
					for(int j=s[2];j<=s[4];j++) {
						board[i][j] -= s[5];
					}
				}
			} else {
				for(int i=s[1];i<=s[3];i++) {
					for(int j=s[2];j<=s[4];j++) {
						board[i][j] += s[5];
					}
				}
			}
		}
		int answer = 0;
		for (int[] b : board) {
			for (int i : b) {
				if(i>0) {
					answer++;
				}
			}
		}
		return answer;
	}
}
