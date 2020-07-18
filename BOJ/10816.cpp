//백준 - 숫자 카드 2 - 10816
#include<iostream>
#include<math.h>
using namespace std;
int n, m, r[500000], w, i, k[20000001];
int main() {
	cin.tie(0);
	ios_base::sync_with_stdio(false);
	for (cin >> n; i < n; i++) {
		cin >> r[i];
		if (r[i] < 0)
			k[abs(r[i]) + 10000000]++;
		else
			k[r[i]]++;
	}
	for (cin >> m, i = 0; i < m; i++) {
		cin >> w;
		if (w < 0)
			cout << k[abs(w) + 10000000] << " ";
		else
			cout << k[w] << " ";
	}
}