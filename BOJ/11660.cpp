//백준 - 11660 - 구간 합 구하기 5
#include<iostream>
using namespace std;
int n, m, a[1025][1025], i = 1, j, b, c, d, e, sum;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	for (cin >> n >> m; i <= n; i++)
		for (j = 1; j <= n; cin >> a[i][j],a[i][j]+=a[i][j-1],j++);
	for (i = 0; i < m; i++) {
		cin >> b >> c >> d >> e;
		for (sum = 0, j = b; j <= d;sum+= a[j][e] - a[j][c - 1], j++);
		cout << sum << "\n";
	}
}