package ps.programmers.level2;

import java.util.Arrays;

// 2018 KAKAO BLIND RECRUITMENT -[1차] 프렌즈4블록
// 2022/03/26 14:39~14:50,16:42~17:36  = 11+54 = 65분 다시 ㅠㅠ
public class FriendsFourBlock {
	char[][] boardChars;
	boolean[][] boardRemove;

	public void init(int m, int n, String[] board) {
		boardChars = new char[m+1][n+1];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				boardChars[i][j] = board[i].charAt(j);
			}
		}
	}

	public int solution(int m, int n, String[] board) {
		init(m,n,board);
		int answer = 0;
		for(int sum=-1;sum != 0; answer += sum) {
			checkRemoveBlock(m, n);
			sum = removeAndGetBlock(m,n);
			arrange(m,n);
		}
		return answer;
	}

	public void checkRemoveBlock(int m, int n) {
		boardRemove = new boolean[m+1][n+1];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(boardChars[i][j] != 0 && valid(i,j)) {
					boardRemove[i][j] = boardRemove[i+1][j]  = boardRemove[i][j+1] = boardRemove[i+1][j+1] = true;
				}
			}
		}
	}

	public int removeAndGetBlock(int m, int n) {
		int sum = 0;
		for(int i=0;i<m;i++) {
			for (int j = 0; j < n; j++) {
				if(boardRemove[i][j]) {
					boardChars[i][j] = 0;
					sum++;
				}
			}
		}
		return sum;
	}

	private boolean valid(int i, int j) {
		for(int k=0;k<2;k++) {
			for(int l=0;l<2;l++) {
				if(boardChars[i][j]!=boardChars[i+k][j+l]) {
					return false;
				}
			}
		}
		return true;
	}

	public void arrange(int m, int n) {
		for(int i=0;i < n;i++) {
			for(int j=m-1;j>=0;j--) {
				if(boardChars[j][i]!=0) {
					continue;
				}
				for(int k=j-1;k>=0;k--) {
					if(boardChars[k][i]!=0) {
						boardChars[j][i] = boardChars[k][i];
						boardChars[k][i] = 0;
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		FriendsFourBlock friendsFourBlock = new FriendsFourBlock();
		friendsFourBlock.solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
	}
}
