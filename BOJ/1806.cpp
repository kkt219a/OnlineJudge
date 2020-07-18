// 1806 - 부분합 - 투포인터

#include<iostream>
#include<algorithm>
using namespace std;
int n, m, j, k, s, c = 100001, a[100001], i;
int main() {
	for (cin >> n >> m; i < n; cin >> a[i++]);
	for (;;) {
		if (s >= m) {
			c = min(c, k - j);
			s -= a[j++];
		}
		else if (n == k) break;
		else s += a[k++];
	}
	cout << ((c == 100001) ? 0 : c);
}