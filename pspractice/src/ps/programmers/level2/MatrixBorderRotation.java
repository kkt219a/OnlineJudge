package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2021 Dev-Matching: 웹 백엔드 개발자(상반기) - 행렬 테두리 회전하기
// 2022/04/03 19:07~19:59 =52분, 느림 다시
public class MatrixBorderRotation {
	int[][] arr;
	public int[] solution(int rows, int columns, int[][] queries) {
		List<Integer> answers = new ArrayList<>();
		arr = new int[rows][columns];
		int v = 1;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				arr[i][j] = v++;
			}
		}
		for (int[] q : queries) {
			answers.add(rotate(q[0]-1,q[1]-1,q[2]-1,q[3]-1));
			for(int[] a : arr) {
				System.out.println(Arrays.toString(a));
			}
			System.out.println();
		}
		return answers.stream().mapToInt(Integer::intValue).toArray();
	}

	public int rotate(int x1, int y1, int x2, int y2) {
		int min = arr[x1][y1];
		int prev = -1, prevTemp = -1;
		int i,j;
		for(prev=arr[x1][y1], j = y1+1;j<=y2;j++) {
			min = Math.min(min,arr[x1][j]);
			prevTemp = arr[x1][j]; // [2,1]을 prevTemp에 넣는다. // [3,1]을 prevTemp에 넣는다.
			arr[x1][j] = prev; // [2,1]에 [1,1]을 넣는다. // [3,1]에 [2,1]의 값을 넣는다.
			prev = prevTemp; // [2,1]값을 prev에 넣는다. // [3,1]값을 prevTemp에 넣는다. //[n,1]을 prev에 넣는다.
		}
		for(j--, i= x1+1;i<=x2;i++) {
			min = Math.min(min,arr[i][j]);
			prevTemp = arr[i][j]; //[n,2]을 prevTemp에 넣는다.
			arr[i][j] = prev; // [n,2]에 [n,1]를 넣는다.
			prev = prevTemp; // [n,2]값을 prev에 넣는다.
		}
		for(i--, j = y2-1;y1<=j;j--) {
			min = Math.min(min,arr[i][j]);
			prevTemp = arr[i][j]; // [n-1,n]을 prevTemp에 넣는다.
			arr[i][j] = prev; // [n-1,n]에 [n,n]을 넣는다.
			prev = prevTemp; // [n-1,n]의 값을 prev에 넣는다.
		}
		for(j++, i= x2-1;x1<=i;i--) {
			min = Math.min(min,arr[i][j]);
			prevTemp = arr[i][j];
			arr[i][j] = prev;
			prev = prevTemp;
		}
		return min;
	}

	public static void main(String[] args) {
		MatrixBorderRotation matrixBorderRotation = new MatrixBorderRotation();
		int[] solution = matrixBorderRotation.solution(6, 6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}});
		System.out.println("Arrays.toString(solution) = " + Arrays.toString(solution));
	}
}
