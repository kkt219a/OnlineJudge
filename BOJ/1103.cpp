// 1103 - 게임  - DFS+DP의 조합 어렵다 다시하자 
#include<iostream>
#include<algorithm>
using namespace std;
char map[50][51];
int dp[50][50], dis[4][2] = { {-1,0},{0,1},{1,0},{0,-1} }, visit[50][50], i, j, n, m;
int dfs(int x, int y) {
	if (x < 0 || x >= n||y < 0 || y >= m||map[x][y] == 'H') return 0;
	if (visit[x][y]) { cout << "-1"; exit(0); }
	if (dp[x][y]) return dp[x][y];
	visit[x][y] = 1;
	for (int k = 0; k < 4; k++)
		dp[x][y] = max(dp[x][y], dfs(x+(map[x][y] - 48)* dis[k][0], y + (map[x][y] - 48)* dis[k][1]) + 1);
	visit[x][y] = 0;
	return dp[x][y];
}
int main() {
	for (cin >> n >> m; i < n; cin >> map[i++]);
	cout << dfs(0, 0);
}