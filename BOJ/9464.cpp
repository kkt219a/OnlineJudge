//9464- 직사각형 집합 - 원시 피타고라스 수

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int m, n, t, l, cl, ch, cnt, i;
vector<int> v;
int gcd(int a, int b) { return (a == 0) ? b : gcd(b % a, a); }
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
	for (v.clear(), m = 2; m < 100; m++)
		for (n = (m % 2 == 1) ? 2 : 1; n < m; n += 2) {
			if (gcd(n, m) != 1)
				continue;
			v.push_back(2 * (m * m - n * n + 2 * m * n));
		}
	sort(v.begin(), v.end());
	for (cin >> t; t--;) {
		cin >> l;
		for (cnt = cl = i = 0;; i++) {
			if (cl + v[i] > l)
				break;
			cl += v[i];
			cnt++;
		}
		cout << cnt << "\n";
	}
}