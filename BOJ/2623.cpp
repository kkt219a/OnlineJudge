// 2623 - 음악 프로그램 - DFS 스택 위상정렬

#include<iostream>
#include<stack>
#include<vector>
using namespace std;
int n, m, i, a, j, pr, now, vi[1001], fi[1001], cycle;
vector<int> v[1001];
stack<int> s;
void dfs(int k) {
	vi[k] = 1;
	for (int y : v[k]) {
		if (!vi[y]) dfs(y);
		if (!fi[y]) { cycle = 1; return; }
	}
	fi[k] = 1;
	s.push(k);
}
int main() {
	for (cin >> n >> m; i < m; i++) {
		cin >> a;
		for (j = 0; j < a; j++) {
			if (j == 0) cin >> pr;
			else {
				cin >> now;
				v[pr].push_back(now);
				pr = now;
			}
		}
	}
	for (i = 1; i <= n && !cycle; i++) if (!vi[i]) dfs(i);
	if (cycle) cout << "0\n";
	else for (; !s.empty(); cout << s.top() << "\n", s.pop());
}