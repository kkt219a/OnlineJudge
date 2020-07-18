//백준 - 나무 자르기 - 2805
#include<iostream>
#include<algorithm>
using namespace std;
int n, m, a[1000000], i, s, e, t;
long long an, h;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (cin >> n >> m; i < n; cin >> a[i++], e = max(e, a[i - 1]));
	for (; s <= e;) {
		t = (s + e) / 2;
		for (h=0, i = 0; i < n; i++)
			if (t < a[i])
				h += (a[i] - t);
		if (h < m)
			e = t - 1;
		else if (h >= m) {
			if (an<t)
				an = t;
			s = t + 1;
		}
	}
	cout << an;
}
