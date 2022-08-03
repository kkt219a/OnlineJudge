package ps.baekjoon;

// 2022/08/04 02:16 ~ 02:32 = 16분
public class P14888 {
	static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] a;

	public static void main(String[] args) throws Exception {
		n = read();
		a = new int[n];
		for (int i = 0; i < n; a[i++] = read());
		dfs(1,a[0],read(),read(),read(),read());
		System.out.println(new StringBuilder().append(max).append("\n").append(min));
	}

	private static void dfs(int depth, int ans, int p, int m, int mu, int d) {
		if (depth == n) {
			max = Math.max(max, ans);
			min = Math.min(min, ans);
		} else {
			if(p>0) {
				dfs(depth+1, ans+a[depth],p-1,m,mu,d);
			}
			if(m>0) {
				dfs(depth+1, ans-a[depth],p,m-1,mu,d);
			}
			if(mu>0) {
				dfs(depth+1, ans*a[depth],p,m,mu-1,d);
			}
			if(d>0) {
				dfs(depth+1, ans/a[depth],p,m,mu,d-1);
			}
		}
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
