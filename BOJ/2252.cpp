// 2252 - 줄 세우기 - DFS 스택 위상정렬

#include<iostream>
#include<stack>
#include<vector>
using namespace std;
stack<int> s;
int n, m, i, vi[32001], a, b;
vector<int> v[32001];
void dfs(int k) {
	vi[k] = 1;
	for (int i = 0; i < v[k].size(); i++)
		if (!vi[v[k][i]])
			dfs(v[k][i]);
	s.push(k);
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> n >> m; i < m; i++, cin >> a >> b, v[a].push_back(b));
	for (i = 1; i <= n; i++)
		if (!vi[i]) dfs(i);
	for (; !s.empty(); cout << s.top() << " ", s.pop());
}