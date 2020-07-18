// 1697 - 숨바꼭질 - BFS

#include<iostream>
#include<queue>
#define num 100000
using namespace std;
int n, k, r, i, a;
bool v[100001];
queue<pair<int, int> > q;
int bfs() {
	q.push(make_pair(n, 0));
	v[n] = 1;
	for (; !q.empty();q.pop()) {
		a = q.front().first;
		if (a == k) return q.front().second;
		if (a + 1 >= 0 && a + 1 <= num && !v[a+1]) { q.push(make_pair(a + 1, q.front().second+1)); v[a + 1] = 1; }
		if (a - 1 >= 0 && a - 1 <= num && !v[a-1]) { q.push(make_pair(a - 1, q.front().second+1)); v[a - 1] = 1; }
		if (a*2 >= 0 && a*2 <= num && !v[a*2]) { q.push(make_pair(a*2, q.front().second)); v[a*2] = 1; }
	}
}
int main() {
	cin >> n >> k;
	cout<<bfs();
}