// 1715 - 카드 정렬하기 - 최소 힙

#include<iostream>
#include<queue>
using namespace std;
priority_queue<int, vector<int>, greater<int> > q;
int n, a, ret, b, c;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> n; n--; cin >> a, q.push(a));
	while (q.size() > 1) {
		b = q.top(); q.pop();
		c = q.top(); q.pop();
		ret += b + c;
		q.push(b + c);
	}
	cout << ret;
}