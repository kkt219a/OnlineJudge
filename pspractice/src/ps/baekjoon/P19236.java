package ps.baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// 2022/07/22
public class P19236 {
	static int[] dx = {-1,-1,0,1,1,1,0,-1}, dy = {0,-1,-1,-1,0,1,1,1};
	static int[][] num, dir;
	static List<Fish> fishList = new ArrayList<>();
	static int max;
	public static void main(String[] args) throws Exception {
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				num[i][j] = read();
				dir[i][j] = read() -1;
				fishList.add(new Fish(i,j,num[i][j],dir[i][j]));
			}
		}
		Fish shark = new Fish(0, 0, num[0][0], dir[0][0]);
		dir[0][0] = num[0][0] = 0;
		fishList.sort(Comparator.comparingInt(o -> o.size));
		dfs(shark, num, dir);
		System.out.println(max);
	}

	static int[][] copy(int[][] origin) {
		int[][] copy = new int[4][4];
		for(int i=0;i<4;i++) {
			System.arraycopy(origin[i], 0, copy[i], 0, 4);
		}
		return copy;
	}

	private static void dfs(Fish shark, int[][] num, int[][] dir) {
		max = Math.max(shark.size, max);
		int[][] newNum = copy(num), newDirs = copy(dir);
		//모든 물고기 이동
		for (Fish fish : fishList) {
			// 8방향 중 가능한 곳이면 이동
			for(int i=0, j=fish.dir;i<8;i++, j = (j+7)%8) {
				int newX = fish.x+dx[j], newY = fish.y+dy[j];
				if (isLimited(newX, newY)||(newX==shark.x&&newY== shark.y)) {
				} else {
					for (Fish fish1 : fishList) {
						if(fish1.x == newX && fish1.y == newY) {
							fish1.x = fish.x;
							fish1.y = fish.y;
							fish.x = newX;
							fish.y = newY;
							newNum[newX][newY] = fish.size;
							newNum[fish1.x][fish1.y] = fish1.size;
							newDirs[newX][newY] = fish.dir;
							newDirs[fish1.x][fish1.y] = fish1.dir;
						}
					}
					break;
				}
			}
		}

		// 상어의 이동
		int newX = shark.x+dx[shark.dir], newY = shark.y+dy[shark.dir];
		while(isLimited(newX, newY)) {
			int newSize = newNum[newX][newY], newDir = newDirs[newX][newY];
			if(newNum[newX][newY]!=0) {
				newNum[newX][newY] = newDirs[newX][newY] = 0;
				dfs(new Fish(newX, newY, shark.size + newSize, newDir), newNum, newDirs);
				newNum[newX][newY] = newSize;
				newDirs[newX][newY] = newDir;
			}
			newX += dx[shark.dir];
			newY += dy[shark.dir];
		}
	}

	private static boolean isLimited(int x, int y) {
		return x>=0&&y>=0&&x<4&&y<4;
	}

	static class Fish {
		int x, y, size, dir;
		public Fish(int x, int y, int size, int dir) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.dir = dir;
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
