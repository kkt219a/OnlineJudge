//1725 - 히스토그램 - 스택 - 다시 

#include<iostream>
#include<stack>
#include<algorithm>
using namespace std;
int n, i, ans = -1, a[100000], w, v;
stack<int> s;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n; i < n; cin>>a[i++]);
	for (a[i]=0,i = 0; i <= n; i++) {
		while (!s.empty() && a[s.top()] >= a[i]) {
			v = s.top();
			s.pop();
			if (s.empty()) w = i;
			else w = i - s.top() - 1;
			ans = max(ans, w*a[v]);
		}
		s.push(i);
	}
	cout << ans;
}