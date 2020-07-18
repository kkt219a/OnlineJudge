//백준 - 16194 - 카드 구매하기 2
#include<iostream>
#include<algorithm>
using namespace std;
int dp[1001], a[1001], i = 1, n, j;
int main() {
	for (cin >> n; i <= n; cin >> a[i], dp[i]=9999, i++);
	for (i = 1; i <= n; i++)
		for (j = i; j >= 0; dp[i] = min(dp[i - j] + a[j], dp[i]), j--);
	cout << dp[n];
}