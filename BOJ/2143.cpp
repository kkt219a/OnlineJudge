// 2143 - 두 배열의 합
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
long long t, n, m, i, a[1000], b[1000], j, k, l, cnt;
vector<long long> c, d;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> t >> n; i < n; cin >> a[i], i++);
	for (cin >> m, i = 0; i < m; cin >> b[i], i++);
	for (i = 0; i < n; i++)
		for (j = i; j < n; j++,k++) {
			if (i == j)
				c.push_back(a[j]);
			else
				c.push_back(c.back() + a[j]);
		}
	for (i = 0; i < m; i++)
		for (j = i; j < m; j++,l++) {
			if (i == j)
				d.push_back(b[j]);
			else
				d.push_back(d.back() + b[j]);
		}
	sort(d.begin(), d.end());
	for (i = 0; i < k; i++)
		cnt += upper_bound(d.begin(), d.end(), t - c[i]) - lower_bound(d.begin(), d.end(), t - c[i]);
	cout << cnt;
}