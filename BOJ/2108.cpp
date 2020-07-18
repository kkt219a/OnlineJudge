// 2108 - 통계학
#include<iostream>
#include<math.h>
#include<algorithm>
using namespace std;
int mi = 4001, ma = -4001, ma2, ve[500000], n, v, i;
double s;
struct l {int a, b;};
l c[8002];
bool k(l a, l b) {
	if (a.b == b.b)
		return a.a < b.a;
	return a.b > b.b;
}
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(false);
	for (cin>>n; i<n;i++) {
		cin >> v;
		if (v < 0) {
			c[4000-v].a = v;
			c[4000-v].b++;
		}
		else {
			c[v].a = v;
			c[v].b++;
		}
		mi=min(v, mi);
		ma = max(v, ma);
		s += v;
		ve[i] = v;
	}
	sort(ve, ve + n);
	sort(c, c + 8001,k);
	cout << round(s / n) << "\n";
	cout << ve[(n - 1) / 2] << "\n";
	if (c[0].b == c[1].b)
		ma2 = c[1].a;
	else
		ma2 = c[0].a;
	cout << ma2 << "\n" << ma - mi;
}