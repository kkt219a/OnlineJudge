// 1707 - 이분그래프 - DFS

#include<iostream>
#include<vector>
using namespace std;
int t, v, e, i, a, b, c[20001], j;
vector<int> g[20001];
void dfs(int num, int color) {
	int p, k;
	c[num] = color;
	for (k = 0; k < g[num].size(); k++) {
		p = g[num][k];
		if (!c[p]) dfs(p, 3 - color);
	}
}
bool ch() {
	for (i = 1; i <= v; i++)
		for (j = 0; j < g[i].size(); j++)
			if (c[g[i][j]] == c[i])
				return 0;
	return 1;
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> t; t--;) {
		cin >> v >> e;
		for (i = 0; i < e; cin >> a >> b, g[a].push_back(b), g[b].push_back(a), i++);
		for (i = 1; i <= v; i++)
			if (c[i] == 0)
				dfs(i, 1);
		cout << ((ch()) ? "YES\n" : "NO\n");
		for (i = 0; i < 20001; c[i] = 0, g[i++].clear());
	}
}
