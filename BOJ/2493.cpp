//2493 - 탑
#include<iostream>
#include<stack>
using namespace std;
stack<pair<int, int> > s; 
int n, i = 1, m;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	for (cin >> n;i<=n;i++) {
		cin >> m;
		for (; !s.empty();) {
			if (s.top().second > m) {
				cout << s.top().first << " ";
				break;
			}
			s.pop();
		}
		if (s.empty())
			cout << "0 ";
		s.push(make_pair(i, m));
	}
}
