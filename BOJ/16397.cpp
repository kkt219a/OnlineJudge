// 16397 - 탈출 - BFS

#include<iostream>
#include<queue>
#define ma 99999
using namespace std;
int n, t, g, cnt, a, b, i;
queue<pair<int, int> > q;
bool visited[100000], k = 1;
int bfs(int nn, int tt, int gg) {
	for (visited[nn] = 1, q.push(make_pair(nn, 0)); !q.empty() && tt >= q.front().second; k = 1) {
		if (q.front().first == gg) return q.front().second; //수를 찾았으면 스탑
		a = q.front().first + 1;
		b = q.front().first * 2;
		if (b > ma) k = 0; //2배한게 10만 넘으면 얜 안 넣기
		for (i = 1; b / i > 9; i *= 10);
		if (b != 0) b -= i; //제일 큰 자리수 1빼기
		if (!visited[a] && a <= ma) { q.push(make_pair(a, q.front().second + 1)); visited[a] = 1; }
		if (!visited[b] && k) { q.push(make_pair(b, q.front().second + 1)); visited[b] = 1; }
		q.pop();
	}
	return -1;
}
int main() {
	cin >> n >> t >> g;
	cnt = bfs(n, t, g);
	if (cnt == -1) cout << "ANG";
	else cout << cnt;
}