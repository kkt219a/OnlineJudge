package ps.programmers.level2;

// 연습문제 - 행렬의 곱셈
// 2022/03/22 16:05~16:34 = 29분 - 느림 - 다시
public class MatrixMultiplication {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr2[0].length; j++) {
				for(int k=0;k<arr2.length;k++) {
					answer[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		return answer;
	}
	public static void main(String[] args) {
		MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
		matrixMultiplication.solution(new int[][]{{1, 4}, {3, 2}, {4, 1}}, new int[][]{{3,3}, {3, 3}});
	}
}
