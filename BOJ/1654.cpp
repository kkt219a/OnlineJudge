//1654 - 랜선 자르기

#include<iostream>
#include<algorithm>
using namespace std;
int k, n, i, j, a[10001], e;
long long sum, m, s, ans;
int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
	for (cin >> k >> n; i < k; cin >> a[i++],e=max(e,a[i-1]));
	for (; s <= e;) {
		m = (s + e) / 2?(s+e)/2:1;
		for (sum = 0, j = 0; j < k; sum += (a[j] / m), j++);
		if (sum >= n) {
			ans = max(ans, m);
			s = m + 1;
		}
		else if (sum < n)
			e = m - 1;
	}
	cout << ans;
}