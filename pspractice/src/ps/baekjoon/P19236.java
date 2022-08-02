package ps.baekjoon;

// 2022/08/02 20:04 ~ 21:03  = 59분
public class P19236 {
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, -1, -1, -1, 0, 1, 1, 1};
	static int max = -1;

	public static void main(String[] args) throws Exception {
		Fish[][] fishArray = new Fish[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				fishArray[i][j] = new Fish(read(), read() - 1);
			}
		}
		Shark shark = new Shark(0, 0, fishArray[0][0].dir, fishArray[0][0].number);
		dfs(fishArray, shark, 0, 0);
		System.out.println(max);
	}

	private static void dfs(Fish[][] fishArray, Shark shark, int eatX, int eatY) {
		Fish[][] copyFish = copy(fishArray);
		copyFish[eatX][eatY] = null;
		System.out.println("현재 상어 위치: " + shark.x + " " + shark.y);
		for (Fish[] fish : copyFish) {
			for (Fish fish1 : fish) {
				System.out.print(fish1 == null ? 0 + " " : fish1.number + " ");
			}
			System.out.println();
		}
		System.out.println();
		max = Math.max(max, shark.sum);
		for (int i = 1; i <= 16; i++) {
			int x = 0, y = 0, dir = 0;
			boolean pass = false;
			for (int j = 0; j < 4 && !pass; j++) {
				for (int k = 0; k < 4; k++) {
					if (copyFish[j][k] != null && copyFish[j][k].number == i) {
						x = j;
						y = k;
						dir = copyFish[j][k].dir;
						pass = true;
						break;
					}
				}
			}
			if (pass) {
				for (int j = dir, k = 0; k < 8; j = (j + 1) % 8, k++) {
					int newX = x + dx[j], newY = y + dy[j];
					if (newX >= 0 && newY >= 0 && newX < 4 && newY < 4 && !(newX == shark.x && newY == shark.y)) {
						Fish tmp = new Fish(i, j);
						copyFish[x][y] = copyFish[newX][newY] != null ?
							new Fish(copyFish[newX][newY].number, copyFish[newX][newY].dir) : null;
						copyFish[newX][newY] = tmp;
						break;
					}
				}
			}
		}
		System.out.println("물고기의 이동");
		for (Fish[] fish : copyFish) {
			for (Fish fish1 : fish) {
				System.out.print(fish1 == null ? 0 + " " : fish1.number + " ");
			}
			System.out.println();
		}
		System.out.println();
		int dist = 1;
		while (true) {
			int newX = shark.x + dx[shark.dir] * dist, newY = shark.y + dy[shark.dir] * dist;
			if (newX < 0 || newY < 0 || newX > 3 || newY > 3) {
				break;
			}
			if (copyFish[newX][newY] != null) {
				dfs(copyFish, new Shark(newX, newY, copyFish[newX][newY].dir, shark.sum + copyFish[newX][newY].number),
					newX, newY);
			}
			dist++;
		}
		System.out.println();

	}

	private static Fish[][] copy(Fish[][] fishArray) {
		Fish[][] ret = new Fish[4][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (fishArray[i][j] != null) {
					ret[i][j] = new Fish(fishArray[i][j].number, fishArray[i][j].dir);
				}
			}
		}
		return ret;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class Fish {
		int number;
		int dir;

		public Fish(int number, int dir) {
			this.number = number;
			this.dir = dir;
		}
	}

	static class Shark {
		int x, y, dir, sum;

		public Shark(int x, int y, int dir, int sum) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.sum = sum;
		}
	}
}
