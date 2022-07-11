package ps.baekjoon;

import java.util.Deque;
import java.util.LinkedList;

public class P16235V2 {
	static int n, m, k;
	static Land[][] lands;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1}, dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) throws Exception {
		n = read();
		lands = new Land[n + 1][n + 1];
		m = read();
		k = read();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				lands[i][j] = new Land(read());
			}
		}
		for (int i = 1; i <= m; i++) {
			int x = read(), y = read(), age = read();
			lands[x][y].addTree(age);
		}
		while (k-- > 0) {
			season(0);
			season(2);
			season(3);
		}
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				cnt += lands[i][j].aliveTree.size();
			}
		}
		System.out.println(cnt);
	}

	static void season(int v) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (v == 0) {
					lands[i][j].Spring();
				} else if (v == 2) {
					int number = lands[i][j].reproducibleTree();
					if (number != 0) {
						for (int k = 0; k < 8; k++) {
							int newX = i + dx[k], newY = j + dy[k];
							if (newX > 0 && newY > 0 && newX <= n && newY <= n) {
								lands[newX][newY].fall(number);
							}
						}
					}
				} else if (v == 3) {
					lands[i][j].Winter();
				}
			}
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class Land {
		Deque<Tree> aliveTree = new LinkedList<>();
		int nutrient = 5;
		int origin;

		public Land(int origin) {
			this.origin = origin;
		}

		void Spring() {
			int cnt = aliveTree.size(), i = 0;
			for (; i < cnt; i++) {
				Tree tree = aliveTree.poll();
				if (nutrient - tree.age >= 0) {
					tree.addAge();
					aliveTree.offer(tree);
					nutrient -= (tree.age - 1);
				} else {
					nutrient += tree.age / 2;
					break;
				}
			}
			for (i++; i < cnt; i++) {
				nutrient += aliveTree.poll().age / 2;
			}
		}

		int reproducibleTree() {
			int cnt = 0;
			for (Tree tree : aliveTree) {
				if (tree.age % 5 == 0) {
					cnt++;
				}
			}
			return cnt;
		}

		void fall(int number) {
			for (int i = 0; i < number; i++) {
				aliveTree.addFirst(new Tree(1));
			}
		}

		void Winter() {
			this.nutrient += origin;
		}

		void addTree(int age) {
			aliveTree.add(new Tree(age));
		}
	}

	static class Tree {
		int age;

		public Tree(int age) {
			this.age = age;
		}

		void addAge() {
			this.age++;
		}
	}
}
