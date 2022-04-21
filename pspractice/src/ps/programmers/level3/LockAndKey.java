package ps.programmers.level3;

import java.util.Arrays;

// 2020 KAKAO BLIND RECRUITMENT - 자물쇠와 열쇠
// 2022/04/22 02:00~03:47 = 107분......
public class LockAndKey {
	int[][] realKey;
	int[][] realLock;
	int M, A, N;
	int lockStart, lockEnd;
	public void rotate() {
		int[][] keyTemp = new int[M][M];
		for(int i = 0; i< M; i++) {
			for(int j = 0; j< M; j++) {
				keyTemp[M - j - 1][i] = realKey[i][j];
			}
		}
		realKey = keyTemp.clone();
	}

	public boolean solution(int[][] key, int[][] lock) {
		M= key.length; // 4
		N = lock.length; // 3
		A = N+2*M-2;// 9
		realKey = new int[M][M];
		realLock = new int[A][A];
		lockStart = M-1;
		lockEnd = N+M-1;
		for(int i=0;i< M;i++) {
			System.arraycopy(key[i], 0, realKey[i], 0, M);
		}
		//init
		for(int i = 0; i< A; i++) {
			for(int j = 0; j< A; j++) {
				if(i>=lockStart&&j>=lockStart&&i< lockEnd&&j<lockEnd) {
					realLock[i][j] = lock[i-M+1][j-M+1];
				}
			}
		}
		for(int k=0;k<4;k++) {
			for(int i = 0; i<= A-M; i++) {
				for (int j = 0; j <= A-M; j++) {
					if(check(i,j)) {
						return true;
					}
				}
			}
			rotate();
		}
		return false;
	}

	private boolean check(int startX, int startY) {
		boolean pass=true;
		int[][] tempRealLock = new int[A][A];
		for(int i=0;i< A;i++) {
			System.arraycopy(realLock[i], 0, tempRealLock[i], 0, A);
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				if(realLock[startX+i][startY+j]==0 && realKey[i][j]==1) {
					realLock[startX + i][startY + j] = realKey[i][j];
				} else if(realLock[startX+i][startY+j]==1 && realKey[i][j]==1) {
					realLock[startX+i][startY+j] = 0;
				}
			}
		}
		for(int i=lockStart;i<lockEnd;i++) {
			for(int j=lockStart;j<lockEnd;j++) {
				if (realLock[i][j] == 0) {
					pass = false;
				}
			}
		}
		for(int i=0;i<M;i++) {
			for(int j=0;j<M;j++) {
				realLock[startX + i][startY + j] = tempRealLock[startX+i][startY+j];
			}
		}
		return pass;
	}

	public static void main(String[] args) {
		LockAndKey lockAndKey = new LockAndKey();
		boolean solution = lockAndKey.solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}},
			new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}});
		System.out.println(solution);
	}

}
