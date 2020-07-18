// 2293 - 동전 1 - dp - 다시

#include<iostream>
using namespace std;
int dp[10001], n, k, i, j, a;
int main() {
	for (cin >> n >> k, dp[0] = 1; i < n; i++)
		for (cin >> a, j = 1; j <= k; dp[j] += (j >= a) ? dp[j - a] : 0, j++); // 이 동전을 포함한 dp값 구하기
	cout << dp[k];
}