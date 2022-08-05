package ps.baekjoon;

// 2022/08/04 60분
public class P20055 {
	static int n, k, durability, ans = 1, rCnt = 1;
	static int[] a, r;

	public static void main(String[] args) throws Exception {
		n = read();
		k = read();
		a = new int[2 * n];
		r = new int[2 * n];
		for (int i = 0, j = 2 * n; i < j; a[i++] = read());
		while (true) {
			// 1. 오른쪽 회전, 로봇들도 오른쪽 회전
			for (int i = 2 * n - 1; i > 0; i--) {
				int tmp = a[i];
				a[i] = a[i - 1];
				a[i - 1] = tmp;
				tmp = r[i];
				r[i] = r[i - 1];
				r[i - 1] = tmp;
			}
			// n 위치 내리게 해주기
			r[n - 1] = 0;
			for (int i = n-2; i >= 0; i--) {
				if (r[i] != 0 && r[i + 1] == 0 && a[i + 1] >= 1) {
					r[i + 1] = r[i];
					r[i] = 0;
					a[i + 1]--;
					if (a[i + 1] == 0) {
						durability++;
					}
				}
			}
			r[n-1]=0;

			if (a[0] > 0) {
				r[0] = rCnt++;
				a[0]--;
				if (a[0] == 0) {
					durability++;
				}
			}
			if (durability >= k) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
