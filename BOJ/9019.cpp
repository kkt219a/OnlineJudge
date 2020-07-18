// 9019- DSLR - BFS

#include<iostream>
#include<string>
#include<queue>
using namespace std;
int t, a, b, i, d, s, l, r, n;
bool visited[10000];
queue<pair<int, string> > q;
string bfs(int in, string an) {
	for (q.push(make_pair(in, an)),visited[in]=1; !q.empty();) {
		if (q.front().first == b)
			return q.front().second;
		n = q.front().first;
		d = (n << 1) % 10000;
		s = (n == 0) ? 9999 : n - 1;
		l = ((((n / 100) % 10) * 10 + ((n / 10) % 10)) * 10 + (n % 10)) * 10 + n / 1000;
		r = (((n % 10) * 10 + (n / 1000)) * 10 + ((n / 100) % 10)) * 10 + (n / 10) % 10;
		if (!visited[d]) { q.push(make_pair(d, q.front().second + 'D')); visited[d] = 1; }
		if (!visited[s]) { q.push(make_pair(s, q.front().second + 'S')); visited[s] = 1; }
		if (!visited[l]) { q.push(make_pair(l, q.front().second + 'L')); visited[l] = 1; }
		if (!visited[r]) { q.push(make_pair(r, q.front().second + 'R')); visited[r] = 1; }
		q.pop();
	}
}
int main() {
	for (cin >> t; t--;) {
		cin >> a >> b;
		cout << bfs(a, "") << "\n";
		for (; !q.empty(); q.pop());
		for (i = 0; i < 10000; visited[i++] = 0);
	}
}