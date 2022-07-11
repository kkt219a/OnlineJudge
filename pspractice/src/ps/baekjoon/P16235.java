package ps.baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 2022/07/11 22:42 ~ 23:58 = 76분
public class P16235 {
	static int n, m, k;
	static int[][] original;
	static Land[][] lands;
	static int[] dx={-1,-1,-1,0,0,1,1,1}, dy = {-1,0,1,-1,1,-1,0,1};

	// M개 나무 살건데 땅 하나에 여러개 나무 있을지도
	// 가장 처음 양분은 모든 칸에 5
	public static void main(String[] args) throws Exception {
		n = read();
		original = new int[n+1][n+1]; //1부터 시작
		lands = new Land[n+1][n+1];
		m = read();
		k = read();
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				original[i][j] = read();
				lands[i][j] = new Land();
			}
		}
		for(int i=1;i<=m;i++) {
			int x = read(), y = read(), age = read();
			lands[x][y].addTree(age);
		}
		while (k-- > 0) {
			season(0);
			season(1);
			season(2);
			season(3);
		}
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				cnt += lands[i][j].aliveTree.size();
			}
		}
		System.out.println(cnt);
	}

	static void season(int v) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(v==0) {
					lands[i][j].Spring();
				} else if(v==1) {
					lands[i][j].Summer();
				} else if(v==2) {
					int number = lands[i][j].reproducibleTree();
					if(number != 0) {
						for (int k = 0; k < 8; k++) {
							int newX = i + dx[k], newY = j + dy[k];
							if (newX > 0 && newY > 0 && newX <= n && newY <= n) {
								lands[newX][newY].fall(number);
							}
						}
					}
				} else if(v==3) {
					lands[i][j].Winter(original[i][j]);
				}
			}
		}
	}


	// 봄, 자신의 나이만큼 양분을 먹고(자기칸만) 나이 +1, 여러개라면 어린 나무부터. 못먹으면 죽음

	// 여름, 봄에 죽은 나무가 양분으로 변함. 죽은 나무마다 나이를 2로 나눈 값.

	// 가을, 나무의 번식. 5의 배수 나이만 가능. 인접 8칸(범위 내)에 나이가 1인 나무가 생김

	// 겨울, 기계가 땅을 돌앋니며 땅에 양분 추가. 각 칸에 추가되는 양분의 양은 A[r][c]

	static class Land {
		Queue<Tree> aliveTree = new PriorityQueue<>();
		List<Tree> dieTree = new ArrayList<>();
		int nutrient = 5;
		void Spring() {
			List<Tree> liveTree = new ArrayList<>();
			while(!aliveTree.isEmpty()) {
				Tree tree = aliveTree.poll();
				if(nutrient-tree.age >= 0) {
					tree.addAge();
					liveTree.add(tree);
					nutrient -= (tree.age-1);
				} else {
					dieTree.add(tree);
				}
			}
			aliveTree = new PriorityQueue<>(liveTree);
		}

		void Summer() {
			for (Tree tree : dieTree) {
				nutrient += tree.age/2;
			}
			dieTree.clear();
		}
		int reproducibleTree() {
			int cnt = 0;
			for (Tree tree : aliveTree) {
				if(tree.age%5 == 0) {
					cnt++;
				}
			}
			return cnt;
		}
		void fall(int number) {
			for(int i=0;i<number;i++) {
				aliveTree.offer(new Tree(1));
			}
		}
		void Winter(int nutrient) {
			this.nutrient += nutrient;
		}
		void addTree(int age) {
			aliveTree.add(new Tree(age));
		}
	}

	static class Tree implements Comparable<Tree> {
		int age;
		public Tree(int age) {
			this.age = age;
		}
		void addAge() {
			this.age++;
		}
		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
