// 5014 - 스타트링크 - bfs

#include<iostream>
#include<queue>
using namespace std;
int f, s, g, u, d, x, a, b;
bool v[1000001];
queue<pair<int,int> > q;
int bfs(int k) { //
	q.push(make_pair(k,0));
	v[k] = 1;
	for (; !q.empty();q.pop()) {
		if (q.front().first == g)
			return q.front().second;
		a = q.front().first + u;
		b= q.front().first - d;
		if (a > 0 && a <= f && !v[a]) { q.push(make_pair(a, q.front().second+1)); v[a] = 1; }
		if (b > 0 && b <= f && !v[b]) { q.push(make_pair(b, q.front().second+1)); v[b] = 1; }
	}
	return -1;
}
int main() {
	cin >> f >> s >> g >> u >> d;
	x = bfs(s);
	if (x == -1) cout << "use the stairs";
	else cout << x;
}