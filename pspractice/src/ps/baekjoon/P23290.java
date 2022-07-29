package ps.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 2022/07/28 17:02 ~  18:44 = 102분
public class P23290 {
	static int m, s;
	static Aquarium[][] map = new Aquarium[4][4];
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}, dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] ddx = {0, -1, 0, 1, 0}, ddy = {0, 0, -1, 0, 1};
	static int[] shark = new int[2];

	public static void main(String[] args) throws Exception {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				map[i - 1][j - 1] = new Aquarium();
			}
		}
		m = read();
		s = read();
		for (int i = 0; i < m; i++) {
			int x = read(), y = read(), d = read();
			map[x - 1][y - 1].addFish(new Fish(x - 1, y - 1, d - 1));
		}
		shark[0] = read() - 1;
		shark[1] = read() - 1;
		while (s-- > 0) {
			List<Fish> copyFishList = new ArrayList<>();
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					for (Fish fish : map[i][j].fishList) {
						copyFishList.add(new Fish(fish.x, fish.y, fish.d)); // 복제
						boolean moveSuccess = false;
						for (int k = 0, d = fish.d; k < 8; k++, d = (d + 7) % 8) {
							int newX = fish.x + dx[d], newY = fish.y + dy[d];
							if (valid(newX, newY) && !map[newX][newY].isSmell() && !(shark[0] == newX
								&& shark[1] == newY)) {
								fish.d = d;
								fish.x = newX;
								fish.y = newY;
								map[newX][newY].addTmpFish(fish);
								moveSuccess = true;
								break;
							}
						}
						if (!moveSuccess) {
							map[i][j].addTmpFish(fish);
						}
					}
				}
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j].processTmp();
				}
			}

			Queue<Point> sharkMove = new PriorityQueue<>();
			for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= 4; j++) {
					for (int k = 1; k <= 4; k++) {
						int number = i * 100 + j * 10 + k;
						int x1 = shark[0] + ddx[i], y1 = shark[1] + ddy[i];
						int x2 = x1 + ddx[j], y2 = y1 + ddy[j];
						int x3 = x2 + ddx[k], y3 = y2 + ddy[k];
						if (valid(x1, y1) && valid(x2, y2) && valid(x3, y3)) {
							int cnt = map[x1][y1].fishList.size();
							if (!(x1 == x2 && y1 == y2)) {
								cnt += map[x2][y2].fishList.size();
							}
							if (!(x2 == x3 && y2 == y3) && !(x1 == x3 && y1 == y3)) {
								cnt += map[x3][y3].fishList.size();
							}
							sharkMove.offer(new Point(number, cnt));
						}
					}
				}
			}
			Point move = sharkMove.poll();
			for (int i = 0, j = move.number, k = 100; i < 3; i++, j %= k, k /= 10) {
				int d = j / k;
				shark[0] += ddx[d];
				shark[1] += ddy[d];
				map[shark[0]][shark[1]].arriveShark(s - 2);
			}
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j].smellClear(s);
				}
			}
			for (Fish fish : copyFishList) {
				map[fish.x][fish.y].addFish(fish);
			}
		}
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cnt += map[i][j].fishList.size();
			}
		}
		System.out.println(cnt);
	}

	private static boolean valid(int x, int y) {
		return x >= 0 && y >= 0 && x < 4 && y < 4;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class Aquarium {
		List<Fish> fishList = new ArrayList<>();
		List<Fish> tmpList = new ArrayList<>();
		List<Integer> fishSmell = new ArrayList<>();

		void addFish(Fish fish) {
			fishList.add(fish);
		}

		void addTmpFish(Fish fish) {
			tmpList.add(fish);
		}

		boolean isSmell() {
			return !fishSmell.isEmpty();
		}

		public void processTmp() {
			fishList.clear();
			fishList.addAll(tmpList);
			tmpList.clear();
		}

		public void arriveShark(int i) {
			if (!fishList.isEmpty()) {
				fishSmell.add(i);
				fishList.clear();
			}
		}

		public void smellClear(int time) {
			fishSmell.removeIf(f -> f == time);
		}
	}

	static class Fish {
		int x, y, d;

		public Fish(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	static class Point implements Comparable<Point> {
		int number, cnt;

		public Point(int number, int cnt) {
			this.number = number;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			int compare = Integer.compare(o.cnt, this.cnt);
			return compare == 0 ? Integer.compare(this.number, o.number) : compare;
		}
	}
}
