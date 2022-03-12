package ps.programmers.level1;

// 연습문제 - 행렬의 덧셈
// 2022/03/13 01:00~01:03 = 3분
public class MatrixAddition {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[i].length; j++) {
				arr2[i][j]+=arr1[i][j];
			}
		}
		return arr2;
	}
}
