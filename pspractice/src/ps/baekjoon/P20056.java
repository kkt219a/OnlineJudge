package ps.baekjoon;

import java.util.ArrayList;
import java.util.List;

// 2022/07/22 19:32 ~ 20:32 = 60분
public class P20056 {
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}, dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static int n, m, k;
	static FireBalls[][] fireBalls;

	public static void main(String[] args) throws Exception {
		n = read();
		m = read();
		k = read();
		fireBalls = new FireBalls[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				fireBalls[i][j] = new FireBalls();
			}
		}
		for (int i = 0; i < m; i++) {
			fireBalls[read() - 1][read() - 1].addFireBallReal(new FireBall(read(), read(), read()));
		}
		for (int z = 0; z < k; z++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (FireBall fireBall : fireBalls[i][j].fireBalls) {
						int newX = (i + dx[fireBall.d] * fireBall.s) % n, newY = (j + dy[fireBall.d] * fireBall.s) % n;
						newX = newX < 0 ? newX + n : newX;
						newY = newY < 0 ? newY + n : newY;
						fireBalls[newX][newY].addFireBall(fireBall);
					}
					fireBalls[i][j].clear();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					fireBalls[i][j].copy();
					if (fireBalls[i][j].fireBalls.size() > 1) {
						fireBalls[i][j].progressFireBalls();
					}
				}
			}
		}
		int ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (FireBall fireBall : fireBalls[i][j].fireBalls) {
					ret += fireBall.m;
				}
			}
		}
		System.out.println(ret);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class FireBall {
		int m, s, d;

		public FireBall(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static class FireBalls {
		List<FireBall> fireBalls = new ArrayList<>();
		List<FireBall> tmp = new ArrayList<>();

		void progressFireBalls() {
			int m = 0, s = 0, odd = 0, even = 0, size = fireBalls.size();
			for (FireBall fireBall : fireBalls) {
				m += fireBall.m;
				s += fireBall.s;
				if (fireBall.d % 2 == 0) {
					even++;
				} else {
					odd++;
				}
			}
			fireBalls.clear();
			if (m != 0 && m/5 != 0) {
				m /= 5;
				s /= size;
				for (int d = odd == 0 || even == 0 ? 0 : 1; d <= 7; d += 2) {
					fireBalls.add(new FireBall(m, s, d));
				}
			}
		}

		void addFireBall(FireBall fireBall) {
			tmp.add(fireBall);
		}

		void copy() {
			fireBalls.addAll(tmp);
			tmp.clear();
		}

		void addFireBallReal(FireBall fireBall) {
			fireBalls.add(fireBall);
		}

		void clear() {
			fireBalls.clear();
		}
	}
}
