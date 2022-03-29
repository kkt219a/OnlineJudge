package ps.programmers.level2;

// 연습문제 - 가장 큰 정사각형 찾기
// 2022/03/29 10:05~ 실패
public class FindLargestSquare {
	int[][] realBoard;
	int answer;
	public int solution(int [][]board) {
		realBoard = new int[board.length+1][board[0].length+1];
		for(int i=1;i< realBoard.length;i++) {
			for(int j=1;j< realBoard[0].length;j++) {
				realBoard[i][j] = board[i-1][j-1];
			}
		}
		for(int i=1;i<realBoard.length;i++) {
			for(int j=1;j<realBoard[i].length;j++) {
				if(realBoard[i][j]==1) {
					realBoard[i][j] = Math.min(Math.min(realBoard[i-1][j],realBoard[i][j-1]),realBoard[i-1][j-1])+1;
					answer= Math.max(realBoard[i][j],answer);
				}
			}
		}
		return answer*answer;
	}
}
