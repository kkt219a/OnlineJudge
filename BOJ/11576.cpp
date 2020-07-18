//백준 - 11576 - Base Conversion
#include<iostream>
#include<stack>
using namespace std;
int f, p, m, i, c = 1, a[25], ans;
stack<int> s;
int main() {
	for (cin >> f >> p >> m; i < m; cin >> a[i++]);
	for (i--; i >= 0; ans += a[i--] * c, c *= f);
	for (; ans!=0; s.push(ans%p), ans /= p);
	while (!s.empty()) {
		cout << s.top() << " ";
		s.pop();
	}
}