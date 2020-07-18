// 백준 - 1743 - 음식물 피하기 - DFS

#include<iostream>
#include<algorithm>
using namespace std;
int p[102][102], i, j, n, m, k, ma, cnt, a, b;
int z[4][2] = { {0,-1},{0,1},{1,0},{-1,0} };
int dfs(int x, int y) {
	p[x][y] = 0;
	cnt++;
	for (int t = 0; t < 4; t++)
		if (p[x + z[t][0]][y + z[t][1]])
			dfs(x + z[t][0], y + z[t][1]);
	return cnt;
}
int main() {
	for (cin >> n >> m >> k; i < k; cin >> a >> b, p[a][b] = 1, i++);
	for (i = 1; i <= n; i++)
		for (j = 1; j <= m; j++, cnt = 0)
			if (p[i][j])
				ma = max(dfs(i, j), ma);
	cout << ma;
}