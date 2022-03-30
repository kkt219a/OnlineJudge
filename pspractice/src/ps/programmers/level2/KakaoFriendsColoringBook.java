package ps.programmers.level2;

import java.util.Arrays;

// 2017 카카오코드 예선 - 카카오프렌즈 컬러링북
// 2022/03/30 11:50~ 12:13
public class KakaoFriendsColoringBook {
	int[] x = new int[]{0,1,0,-1};
	int[] y = new int[]{1,0,-1,0};
	int[][] arr;
	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		arr = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]= picture[i][j];
			}
		}
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]!=0) {
					maxSizeOfOneArea = Math.max(dfs(i,j,arr[i][j]),maxSizeOfOneArea);
					numberOfArea++;
				}
			}
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

	private int dfs(int i, int j, int value) {
		arr[i][j] = 0;
		int sum = 1;
		for(int k=0;k<4;k++) {
			if(i+x[k]<arr.length && i+x[k] >= 0 && j+y[k]<arr[0].length  && j+y[k] >= 0 && arr[i+x[k]][j+y[k]]==value) {
				sum += dfs(i+x[k],j+y[k],value);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		KakaoFriendsColoringBook kakaoFriendsColoringBook = new KakaoFriendsColoringBook();
		int[] solution = kakaoFriendsColoringBook.solution(6, 4,
			new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
		System.out.println(Arrays.toString(solution));
	}
}
