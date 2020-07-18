//9465 - 스티커

#include<iostream>
#include<algorithm>
using namespace std;
int a[100001][2], dp[100001][3], i, n, t;
int main() {
	for (cin >> t; t--;) {
		for (i = 1, cin >> n; i <= n; cin >> a[i++][0]);
		for (i = 1; i <= n; cin >> a[i++][1]);
		for (i=1; i <= n; i++) {
			dp[i][0] = max(max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);
			dp[i][1] = max(dp[i - 1][0], dp[i - 1][2]) + a[i][0];
			dp[i][2] = max(dp[i - 1][0], dp[i - 1][1]) + a[i][1];
		}
		cout << max(max(dp[n][0], dp[n][1]), dp[n][2]) << "\n";
	}
}