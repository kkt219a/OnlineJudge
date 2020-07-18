// 1655 - 가운데를 말해요 - 힙, 우큐 - 다시 ㅠㅠ 

#include<iostream>
#include<queue>
using namespace std;
int n, a, b, c;
priority_queue<int> q;
priority_queue<int, vector<int>, greater<int> > q2;
void solve(int k) {
	if (q.size()==q2.size()) q.push(k);
	else q2.push(k);
	if (!q.empty() && !q2.empty() && q.top() > q2.top()) {
		b = q.top();
		c = q2.top();
		q.pop(); q2.pop();
		q.push(c); q2.push(b);
	}
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> n; n--;) {
		cin >> a;
		solve(a);
		cout << q.top() << "\n";
	}
}