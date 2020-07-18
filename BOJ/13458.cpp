// 13458 - 시험 감독

#include<iostream>
using namespace std;
int n, a[1000000], i, b, c;
long long t, k;
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(false);
	for (cin >> n; i < n; cin >> a[i],i++);
	for (cin >> b >> c, i = 0; i < n; i++) {
		t++;
		if (a[i] <= b)
			continue;
		k = a[i] - b;
		t += k/c;
		if (k%c != 0)
			t++;
	}
	cout << t;
}