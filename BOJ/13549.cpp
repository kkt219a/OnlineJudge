// 13549 - 숨바꼭질3 - bfs가 아닌거같음. 순서따라 달라진다 조심

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
	for (; !q.empty(); q.pop()) {
		a = q.front().first;
		if (a == k) return q.front().second;
		//가까운점을 먼저 방문하는게 bfs인데 이 순서대로해서 우연히! 맞을뿐이다. bfs라 할 수 없다. *2가 가중치가 0이라
		//먼저해야하고 a-1도 먼저해야하는게 우연때문. 다익스트라로 풀어야할듯 
		if (a * 2 >= 0 && a * 2 <= num && !v[a * 2]) { q.push(make_pair(a * 2, q.front().second)); v[a * 2] = 1; }
		if (a - 1 >= 0 && a - 1 <= num && !v[a - 1]) { q.push(make_pair(a - 1, q.front().second + 1)); v[a - 1] = 1; }
		if (a + 1 >= 0 && a + 1 <= num && !v[a + 1]) { q.push(make_pair(a + 1, q.front().second + 1)); v[a + 1] = 1; }

	}
}
int main() {
	cin >> n >> k;
	cout << bfs();
}