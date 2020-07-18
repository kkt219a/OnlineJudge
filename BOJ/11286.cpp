// 11286 - 절대값 힙 - 힙

#include<iostream>
#include<queue>
using namespace std;
priority_queue<int, vector<int>, greater<int> > q, q2;
int n, a;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (cin >> n; n--;) {
		cin >> a;
		if (a == 0) {
			if (!q.empty() && !q2.empty()) {
				if (q.top() >= q2.top()) { cout << (-1)*q2.top() << "\n"; q2.pop(); }
				else { cout << q.top() << "\n"; q.pop(); }
			}
			else if (q.empty() && !q2.empty()) { cout << (-1)*q2.top() << "\n"; q2.pop(); }
			else if (!q.empty() && q2.empty()) { cout << q.top() << "\n"; q.pop(); }
			else cout << "0\n";
		}
		else (a > 0) ? q.push(a) : q2.push(-a);
	}
}