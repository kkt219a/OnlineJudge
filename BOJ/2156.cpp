// 2156 - 포도주 시식
#include<iostream>
#include<algorithm>
using namespace std;
int a[10001], dp[10001][3], n, i = 1;
int main() {
	for (cin>>n;i<=n;i++) {
		cin >> a[i];
		dp[i][0] = max(max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
		dp[i][1] = dp[i - 1][0] + a[i];
		dp[i][2] = dp[i - 1][1] + a[i];
	}
	cout << max(max(dp[n][0], dp[n][1]), dp[n][2]);
}