package ps.baekjoon;

// 2022/08/07 5분
public class P18429 {
	static int n,k,cnt;
	static int[] a;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		n = read();
		k = read();
		a = new int[n];
		visited = new boolean[n];
		for(int i=0;i<n;i++) {
			a[i] = read();
		}
		dfs(1,500);
		System.out.println(cnt);
	}

	private static void dfs(int day, int weight) {
		if(day==n) {
			cnt++;
		} else {
			for (int i = 0; i < n; i++) {
				if (!visited[i] && weight - k + a[i] >= 500) {
					visited[i] = true;
					dfs(day + 1, weight - k + a[i]);
					visited[i] = false;
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
}
