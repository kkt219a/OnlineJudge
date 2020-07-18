// 백준 - 1904 - 01타일
#include<iostream>
int dp[1000001], n, i = 3;
int main() {
	dp[1] = 1; dp[2] = 2;
	std::cin >> n;
	for (; i <= n; i++)
		dp[i] = (dp[i - 1] + dp[i - 2])%15746;
	std::cout << dp[n];
}