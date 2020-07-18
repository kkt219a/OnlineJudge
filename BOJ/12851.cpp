// 12851 - 숨바꼭질2 - BFS  - 다싱

#include<iostream>
#include<queue>
#define num 100000
using namespace std;
int n, k, r, i, a, cnt, ans, b;
bool v[100001];
queue<pair<int, int> > q;
void bfs() {
	q.push(make_pair(n, 0));
	v[n] = 1;
	for (; !q.empty();) {
		a = q.front().first;
		b = q.front().second;
		q.pop();
		v[a] = 1; //이후에 방문!
		if (ans != 0 && ans < b) continue; // ans가 나온상황에서 카운트가 커지면 얘부터 금지
		if (ans &&ans == b && a == k)cnt++; // ans가 있고, 횟수도 같고, 값도 일치하면 카운트 업
		if (!ans&&a == k) { ans = b; cnt++; } // ans 아직 없고  값 같으면
		if (a * 2 >= 0 && a * 2 <= num && !v[a*2]) q.push(make_pair(a * 2, b + 1));
		if (a -1 >= 0 && a -1 <= num && !v[a - 1]) q.push(make_pair(a -1, b+ 1));
		if (a +1 >= 0 && a +1 <= num&&!v[a+1]) q.push(make_pair(a + 1, b+ 1));
	}
}
int main() {
	cin >> n >> k;
	bfs();
	cout << ans <<"\n"<< cnt;
}