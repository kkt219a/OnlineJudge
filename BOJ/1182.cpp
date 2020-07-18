// 1182 - 부분수열의 합

#include<iostream>
using namespace std;
int n, s, m[20], i, c;
void b(int t, int k) {
	int u = k + m[t];
	if (t == n)
		return;
	else if (u == s)
		c++;
	b(t + 1, u);
	b(t + 1, k);
}
int main() {
	for (cin >> n >> s; i < n; cin >> m[i], i++);
	b(0, 0);
	cout << c;
}