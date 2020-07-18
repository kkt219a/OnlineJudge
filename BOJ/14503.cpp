// 14503 - 로봇 청소기 - 단순구현 

#include<iostream>
#include<algorithm>
using namespace std;
int dis[4][2] = { {-1,0},{0,1},{1,0},{0,-1} }, n, m, map[50][50], i, j, cnt, now[2], nowd;
void clean(int x, int y, int d) {
	if (map[x][y] == 0) { map[x][y] = 2; cnt++; }
	int lft = (0 <= d - 1) ? d - 1 : 3, k;
	k = lft;
	do {
		int z = x + dis[lft][0], w = y + dis[lft][1];
		if (map[z][w] == 0 && z >= 0 && w >= 0 && z < n&&w < m)
			clean(z, w, lft);
		lft--;
		lft = (lft == -1) ? 3 : lft;
	} while (k != lft);
	if (d == 0 || d == 1) k=d+2;
	else k=d-2;
	if (x + dis[k][0] < 0 || x + dis[k][0] >= n || y + dis[k][1] < 0 || y + dis[k][1] >= m || map[x + dis[k][0]][y + dis[k][1]] == 1) {
		cout << cnt;
		exit(0);
	}
	else
		clean(x + dis[k][0], y + dis[k][1], d);
}
int main() {
	for (cin >> n >> m>>now[0]>>now[1]>>nowd; i < n; i++)
		for (j=0; j < m; cin >> map[i][j++]);
	clean(now[0], now[1], nowd);
}