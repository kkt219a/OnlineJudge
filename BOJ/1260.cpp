// 1260-DFS와BFS
#include<iostream>
#include<vector>
#include<algorithm>
#include<queue>
using namespace std;
int n, m, s, i, a, b, visit[1001], visit2[1001], j;
vector<int> v[1001];
queue<int> q;
void dfs(int start) {
	visit[start] = 1;
	cout << start << " ";
	for (int k = 0; k < (v[start].size()); k++) {
		if (visit[v[start][k]] == 0) {
			dfs(v[start][k]);
		}
	}
}
void bfs(int start) {
	visit2[start] = 1;
	q.push(start);
	while(!q.empty()){
		start = q.front();
		q.pop();
		cout << start << " ";
		for (j = 0; j < (v[start].size()); j++) {
			if (visit2[v[start][j]] == 0) {
				q.push(v[start][j]);
				visit2[v[start][j]] = 1;
			}
		}
	}
}
int main() {
	cin >> n >> m >> s;
	for (; i < m; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for(i=0;i<=n;i++)
		sort(v[i].begin(), v[i].end());
	dfs(s);
	cout << "\n";
	bfs(s);
}