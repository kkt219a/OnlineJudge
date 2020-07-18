//1413 - 박스 안의 열쇠 - 제 1종 스털링 수

#include<iostream>
using namespace std;
typedef long long ll;
ll n, m, ar[21][21], i, j;
ll gcd(ll a, ll b) {
	return (a == 0) ? b : gcd(b % a, a);
}
int main() {
	cin >> n >> m;
	for (ar[1][1] = 1, i = 1; i <= n; i++)
		for (j = 1; j <= i; j++) {
			if (i == 1 && j == 1) continue;
			ar[i][j] = ar[i - 1][j - 1] + (i - 1) * ar[i - 1][j];
		}
	for (i = 1; i <= n; ar[n][i] += ar[n][i - 1], i++);
	cout << ar[n][m] / gcd(ar[n][m], ar[n][n]) << "/" << ar[n][n] / gcd(ar[n][m], ar[n][n]);
}