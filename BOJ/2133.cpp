// 2133 - 타일 채우기
#include <iostream>
using namespace std;
int dp[31] = { 1,0,3, }, i = 4, n, k, j;
int main() {
	for (cin >> n;(n%2==0)&&i <= n; i += 2) {
		dp[i] = dp[i - 2] * 3;
		for (j = 0; j < i-2;dp[i] += dp[j] * 2, j += 2);
	}
	cout << dp[n];
}