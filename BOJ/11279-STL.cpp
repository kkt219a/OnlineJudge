// 11279 - 최대 힙 - 우선순위 큐
#include<iostream>
#include<queue>
using namespace std;
int n, a;
priority_queue<int > q;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> n; n--;) {
		cin >> a;
		if (a) q.push(a);
		else if (!q.empty()) { cout << q.top()<<"\n"; q.pop(); }
		else { cout << "0\n"; }
	}
}